package Satellite_Control;

import genDevs.*;
import genDevs.modeling.*;
import GenCol.*;
import simView.ViewableAtomic;

public class Ca extends ViewableAtomic {
	double satelliteControlProcessingTime = 50;
	entity currentJob = null;
	DEVSQueue jobQ = null;
	String satelliteAlarmMessageInport = "satelliteAlarmMessageIn";
	String out = "out";
	String wait = "wait";
	String busy = "busy";

	public Ca() {
		this("Ca", 20);
	}

	public Ca(String nm, double cpT) {
		super(nm);
		satelliteControlProcessingTime = cpT;
		jobQ = new DEVSQueue();
		currentJob = new entity("NullJob");
		addInport(satelliteAlarmMessageInport);
		addOutport(out);
	}
	public void initialize() {
		passivateIn(wait);
	}
	public void deltext(double e, message x) {
		Continue(e);

		if (phaseIs(wait)) {
			for (int i = 0; i < x.getLength(); i++) {
				if (messageOnPort(x, satelliteAlarmMessageInport, i)) {
					currentJob = x.getValOnPort(satelliteAlarmMessageInport, i);
					satelliteControlProcessingTime = ((MessageSatelliteControl) currentJob).procTime;
					holdIn("busy", satelliteControlProcessingTime);
				}
			}
		} else if (phaseIs(busy)) {
			for (int i = 0; i < x.getLength(); i++) {
				if (messageOnPort(x, satelliteAlarmMessageInport, i)) {
					entity job = x.getValOnPort(satelliteAlarmMessageInport, i);
					jobQ.add(job);
				}
			}
		}
	}
	public void deltint() {
		if (phaseIs(busy)) {
			if (jobQ.size() != 0) {
				currentJob = (entity) jobQ.pop();
				satelliteControlProcessingTime = ((MessageSatelliteControl) currentJob).procTime;
				holdIn(busy, satelliteControlProcessingTime);
			} else {
				passivateIn(wait);
			}
		}
	}
	public message out() {
		message m = new message();
		if (phaseIs(busy))
			m.add(makeContent(out, currentJob));
		return m;
	}

	public String getTooltipText() {
		return super.getTooltipText() + "\n" + "Queue Size=" + jobQ.size() + "\n" + "currentJob="
				+ currentJob.getName();
	}

}
