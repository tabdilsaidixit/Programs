package Fall2019ClassDemo;

import java.util.Random;

import genDevs.*;
import genDevs.modeling.*;
import GenCol.*;
import simView.ViewableAtomic;


public class carGenerator extends ViewableAtomic{
	double frequencyTime = 8;
	Random ran;
	int jobId=0;

	public carGenerator(){
		this("carGenerator", 8);
	}

	public carGenerator(String nm, double cpT){
		super(nm);
		frequencyTime = cpT;
		addOutport("out");
		ran = new Random();
	}

	public void initialize(){
		holdIn("active", frequencyTime);
	}

	public void deltext(double e,message x){
		Continue(e);
	}

	public void   deltint(){
		jobId++;
		if (phaseIs("active")){
			double nextCarTime = ran.nextDouble()*frequencyTime;
			holdIn("active", nextCarTime);
		}
	}

	public message out(){
		message m = new message();
		if (phaseIs("active")){
			double porcT = 10+10*ran.nextDouble();
			vehicleEntity vEnt = new vehicleEntity("car_"+jobId,porcT,0);
			m.add(makeContent("out", vEnt));
			//m.add(makeContent("out", new entity("car_"+jobId)));
		}
		return m;
	}


}
