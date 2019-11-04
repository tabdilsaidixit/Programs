package Satellite_Control;

import genDevs.*;
import genDevs.modeling.*;
import GenCol.*;
import simView.ViewableAtomic;

public class F3 extends ViewableAtomic {
	double satelliteControlProcessingTime = 50;
	entity currentJob = null;
	DEVSQueue jobQ = null;
	String rawSatelliteAlarmMessageInport = "rawSatelliteAlarmMessageIn";
	String out = "out";
	String wait = "wait";
	String busy = "busy";

	public F3() {
		this("Ca", 20);
	}

	public F3(String nm, double cpT) {
		super(nm);
		satelliteControlProcessingTime = cpT;
		jobQ = new DEVSQueue();
		currentJob = new entity("NullJob");
		addInport(rawSatelliteAlarmMessageInport);
		addOutport(out);
	}

	public void initialize() {
		passivateIn(wait);
	}

	public void deltext(double e, message x) {
		Continue(e);

		if (phaseIs(wait)) {
			for (int i = 0; i < x.getLength(); i++) {
				if (messageOnPort(x, rawSatelliteAlarmMessageInport, i)) {
					currentJob = x.getValOnPort(rawSatelliteAlarmMessageInport, i);
					holdIn("busy", satelliteControlProcessingTime);
				}
			}
		} else if (phaseIs(busy)) {
			for (int i = 0; i < x.getLength(); i++) {
				if (messageOnPort(x, rawSatelliteAlarmMessageInport, i)) {
					entity job = x.getValOnPort(rawSatelliteAlarmMessageInport, i);
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
					currentJob.getName(), satelliteControlProcessingTime, true)));
		return m;
	}

	public String getTooltipText() {
		return super.getTooltipText() + "\n" + "Queue Size=" + jobQ.size() + "\n" + "currentJob="
				+ currentJob.getName();
	}

}
