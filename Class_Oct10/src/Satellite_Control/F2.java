package Satellite_Control;

import genDevs.*;
import genDevs.modeling.*;
import GenCol.*;
import simView.ViewableAtomic;

public class F2 extends ViewableAtomic {
	double satelliteControlProcessingTime = 24;
	entity currentJob = null;
	DEVSQueue jobQ = null;
	String rawSatelliteRegularMessageIn = "rawSatelliteRegularMessageIn";
	String out = "out";
	String wait = "wait";
	String busy = "busy";

	public F2() {
		this("F2", 20);
	}

	public F2(String nm, double cpT) {
		super(nm);
		satelliteControlProcessingTime = cpT;
		jobQ = new DEVSQueue();
		currentJob = new entity("NullJob");
		addInport(rawSatelliteRegularMessageIn);
		addOutport(out);
	}

	public void initialize() {
		passivateIn(wait);
	}

	public void deltext(double e, message x) {
		Continue(e);

		if (phaseIs(wait)) {
			for (int i = 0; i < x.getLength(); i++) {
				if (messageOnPort(x, rawSatelliteRegularMessageIn, i)) {
					currentJob = x.getValOnPort(rawSatelliteRegularMessageIn, i);
					holdIn("busy", satelliteControlProcessingTime);
				}
			}
		} else if (phaseIs(busy)) {
			for (int i = 0; i < x.getLength(); i++) {
				if (messageOnPort(x, rawSatelliteRegularMessageIn, i)) {
					entity job = x.getValOnPort(rawSatelliteRegularMessageIn, i);
					jobQ.add(job);
				}
			}
		}
	}

	public void deltint() {
		if (phaseIs(busy)) {
			if (jobQ.size() != 0) {
				currentJob = (entity) jobQ.pop();
				holdIn(busy, satelliteControlProcessingTime);
			} else {
				passivateIn(wait);
			}
		}
	}

	public message out() {
		message m = new message();
		if (phaseIs(busy))
			m.add(makeContent(out, new MessageSatelliteControl(
					currentJob.getName(), satelliteControlProcessingTime, false)));
		return m;
	}

	public String getTooltipText() {
		return super.getTooltipText() + "\n" + "Queue Size=" + jobQ.size() + "\n" + "currentJob="
				+ currentJob.getName();
	}
}
