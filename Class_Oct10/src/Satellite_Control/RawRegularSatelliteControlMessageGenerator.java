package Satellite_Control;

import java.util.Random;

import genDevs.*;
import genDevs.modeling.*;
import GenCol.*;
import simView.ViewableAtomic;


public class RawRegularSatelliteControlMessageGenerator extends ViewableAtomic{
	double frequencyTime = 16;
	int jobId=0;
	String in = "in";
	String out = "out";
	String active = "active";
	
	public RawRegularSatelliteControlMessageGenerator(){
		this("Raw Regular Satellite Control Message Generator", 16);
	}

	public RawRegularSatelliteControlMessageGenerator(String nm, double cpT){
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
			holdIn(active, frequencyTime);
		}
	}

	public message out(){
		message m = new message();
		if (phaseIs(active)){
			m.add(makeContent("out", new entity("RegularSatelliteControl_"+jobId)));
		}
		return m;
	}


}
