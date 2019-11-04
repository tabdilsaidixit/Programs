package Fall2019ClassDemo;

import genDevs.*;
import genDevs.modeling.*;
import GenCol.*;
import simView.ViewableAtomic;


public class CarWashQ extends ViewableAtomic{
	double carProcessingTime = 20;
	double truckProcessingTime = 2*carProcessingTime;
	entity currentJob=null;
	DEVSQueue jobQ=null;

	public CarWashQ(){
		this("CarWashQ", 20);
	}

	public CarWashQ(String nm, double cpT){
		super(nm);
		carProcessingTime = cpT;
		truckProcessingTime = 2*carProcessingTime;
		jobQ = new DEVSQueue();
		currentJob = new entity("NullJob");
		addInport("carIn");
		addInport("truckIn");
		addOutport("out");
		addTestInput("carIn",new entity("testCar"));
		addTestInput("truckIn",new entity("testTruck"));
	}

	public void initialize(){
		passivateIn("wait");
	}

	public void deltext(double e,message x){
		Continue(e);
		
		if (phaseIs("wait")){
			for (int i = 0; i < x.getLength(); i++){
				if (messageOnPort(x, "carIn", i)) {
					currentJob = x.getValOnPort("carIn", i);
					carProcessingTime = ((vehicleEntity)currentJob).procTime;
					holdIn("busy", carProcessingTime);
				}
				else if (messageOnPort(x, "truckIn", i)) {
					currentJob = x.getValOnPort("truckIn", i);
					holdIn("busy", truckProcessingTime);
				}
			}
		}
		else if (phaseIs("busy")){
			for (int i = 0; i < x.getLength(); i++){
				if (messageOnPort(x, "carIn", i)) {
					entity job = x.getValOnPort("carIn", i);
					jobQ.add(job);
				}
			}
		}
	}

	public void   deltint(){
		if (phaseIs("busy")){
			if(jobQ.size()!=0){
				currentJob=(entity)jobQ.pop();
				String s = currentJob.toString();
				System.out.println(s+"--------------------");
				
				carProcessingTime = ((vehicleEntity)currentJob).procTime;
				holdIn("busy", carProcessingTime);
			}
			else
				passivateIn("wait");
		}		
	}

	public message out(){
		message m = new message();
		if (phaseIs("busy"))
			m.add(makeContent("out", currentJob));
		return m;
	}

	public String getTooltipText(){
		  return
		  super.getTooltipText()
		  +"\n"+"Queue Size="+ jobQ.size()
		  +"\n"+"currentJob="+ currentJob.getName();
		  }

}
