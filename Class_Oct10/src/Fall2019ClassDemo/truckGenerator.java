package Fall2019ClassDemo;

import java.util.Random;

import genDevs.*;
import genDevs.modeling.*;
import GenCol.*;
import simView.ViewableAtomic;


public class truckGenerator extends ViewableAtomic{
	double frequencyTime = 40;
	Random ran;
	int jobId=0;

	public truckGenerator(){
		this("truckGenerator", 8);
	}

	public truckGenerator(String nm, double cpT){
		super(nm);
		frequencyTime = cpT;
		addOutport("out");
		ran = new Random();
	}

	public void initialize(){
		holdIn("active", 5);
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
		if (phaseIs("active"))
			m.add(makeContent("out", new entity("truck_"+jobId)));
		return m;
	}


}
