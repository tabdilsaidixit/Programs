package Satellite_Control;

import genDevs.*;
import genDevs.modeling.*;
import GenCol.*;
import simView.ViewableAtomic;

public class C1 extends ViewableAtomic {
	double scientificExperienceProcessingTime = 20;
	double satelliteControlProcessingTime = 2 * scientificExperienceProcessingTime;
	entity currentJob = null;
	DEVSQueue jobQ = null;
	String scientificMessageInport = "scientificMessageIn";
	String satelliteRegularMessageInport = "satelliteRegualarMessageIn";
	String out = "out";
	String wait = "wait";
	String busy = "busy";

	public C1() {
		this("C1", 20);
	}

	public C1(String nm, double cpT) {
		super(nm);
		scientificExperienceProcessingTime = cpT;
		satelliteControlProcessingTime = 2 * scientificExperienceProcessingTime;
		jobQ = new DEVSQueue();
		currentJob = new entity("NullJob");

		addInport(satelliteRegularMessageInport);
		addInport(scientificMessageInport);
		addOutport(out);
	}

	public void initialize() {
		passivateIn(wait);
	}

	public void deltext(double e, message x) {
		Continue(e);
		if (phaseIs(wait)) {
			for (int i = 0; i < x.getLength(); i++) {
				if (messageOnPort(x, scientificMessageInport, i)) {
					currentJob = x.getValOnPort(scientificMessageInport, i);
					scientificExperienceProcessingTime = ((MessageScientificExperience) currentJob).procTime;
					holdIn("busy", scientificExperienceProcessingTime);
				} else if (messageOnPort(x, satelliteRegularMessageInport, i)) {
					currentJob = x.getValOnPort(satelliteRegularMessageInport, i);
					satelliteControlProcessingTime = ((MessageSatelliteControl) currentJob).procTime;
					holdIn("busy", satelliteControlProcessingTime);
				}
			}
		} else if (phaseIs(busy)) {
			for (int i = 0; i < x.getLength(); i++) {
				if (messageOnPort(x, scientificMessageInport, i)) {
					entity job = x.getValOnPort(scientificMessageInport, i);
					jobQ.add(job);
				}
				if (messageOnPort(x, satelliteRegularMessageInport, i)) {
					entity job = x.getValOnPort(satelliteRegularMessageInport, i);
					jobQ.add(job);
				}
			}
		}
	}

	public void deltint() {
		if (phaseIs(busy)) {
			if (jobQ.size() != 0) {
				currentJob = (entity) jobQ.pop();
				if (currentJob.toString().contains("ScientificExperience")) {
					scientificExperienceProcessingTime = ((MessageScientificExperience) currentJob).procTime;
					holdIn(busy, scientificExperienceProcessingTime);
				} else {
					satelliteControlProcessingTime = ((MessageSatelliteControl) currentJob).procTime;
					holdIn(busy, satelliteControlProcessingTime);
				}

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
