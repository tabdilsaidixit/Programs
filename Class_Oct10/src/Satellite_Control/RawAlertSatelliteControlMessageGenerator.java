package Satellite_Control;

import java.util.Random;

import genDevs.*;
import genDevs.modeling.*;
import GenCol.*;
import simView.ViewableAtomic;


public class RawAlertSatelliteControlMessageGenerator extends ViewableAtomic{
	double frequencyTime = 40;
	int jobId=0;
	String in = "in";
	String out = "out";
	String active = "active";
	
	public RawAlertSatelliteControlMessageGenerator(){
		this("Raw Alert Satellite Control Message Generator", 40);
	}

	public RawAlertSatelliteControlMessageGenerator(String nm, double cpT){
		super(nm);
		frequencyTime = cpT;
		addInport(in);
		addOutport(out);
	}

	public void initialize(){
		holdIn(active, frequencyTime);
	}

	public void deltext(double e,message x){
		Continue(e);
	}

	public void   deltint(){
		jobId++;
		if (phaseIs(active)){
			double nextMessageTime = frequencyTime;
			holdIn(active, nextMessageTime);
		}
	}

	public message out(){
		message m = new message();
		if (phaseIs(active)){
			m.add(makeContent("out", new entity("AlarmSatelliteControl_"+jobId)));
		}
		return m;
	}


}
