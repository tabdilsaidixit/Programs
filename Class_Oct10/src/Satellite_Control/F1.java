package Satellite_Control;

import genDevs.*;
import genDevs.modeling.*;
import GenCol.*;
import simView.ViewableAtomic;

public class F1 extends ViewableAtomic {
	double satelliteControlProcessingTime = 50;
	entity currentJob = null;
	DEVSQueue jobQ = null;
	String rawScientificMessageInport = "rawScientificMessageIn";
	String out = "out";
	String wait = "wait";
	String busy = "busy";

	public F1() {
		this("F1", 20);
	}

	public F1(String nm, double cpT) {
		super(nm);
		satelliteControlProcessingTime = cpT;
		jobQ = new DEVSQueue();
		currentJob = new entity("NullJob");
		addInport(rawScientificMessageInport);
		addOutport(out);
	}

	public void initialize() {
		passivateIn(wait);
	}

	public void deltext(double e, message x) {
		Continue(e);

		if (phaseIs(wait)) {
			for (int i = 0; i < x.getLength(); i++) {
				if (messageOnPort(x, rawScientificMessageInport, i)) {
					currentJob = x.getValOnPort(rawScientificMessageInport, i);
					holdIn("busy", satelliteControlProcessingTime);
				}
			}
		} else if (phaseIs(busy)) {
			for (int i = 0; i < x.getLength(); i++) {
				if (messageOnPort(x, rawScientificMessageInport, i)) {
					entity job = x.getValOnPort(rawScientificMessageInport, i);
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
		m.add(makeContent(out, new MessageScientificExperience(currentJob.getName(),
				satelliteControlProcessingTime)));
		return m;
	}

	public String getTooltipText() {
		return super.getTooltipText() + "\n" + "Queue Size=" + jobQ.size() + "\n" + "currentJob="
				+ currentJob.getName();
	}

}
