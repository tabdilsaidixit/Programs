package Fall2019_class_oct15;

import GenCol.entity;
import simView.ViewableAtomic;

public class CarwashQ extends ViewableAtomic{
	
	entity currentJob = null;
	double carProcessingTime = 20;
	double truckProcessingTime = 2* carProcessingTime;
	public CarwashQ() {
		addInport("carIn");
		addInport("truckIn");
		addOutport("out");
	}
	
	public void intialize() {
		passivateIn("wait");
	}

	public void deltint() {
		
	}
	
	public void deltext() {
		
		
	}
}
