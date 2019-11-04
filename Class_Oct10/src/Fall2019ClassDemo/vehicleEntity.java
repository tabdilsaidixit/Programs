package Fall2019ClassDemo;

import GenCol.entity;

public class vehicleEntity extends entity{
	
	String name = "DefaultName";
	double procTime = 12;
	int priority = 0;

	public vehicleEntity(String nm, double pTime, int _priority){
		super(nm);
		name = nm;
		procTime=pTime;
		priority = _priority;
	}
	
	  public String toString(){
		  return name+"_"+(double)((int)(procTime*100))/100;
		  //return name+"_"+((double)((int)(processingTime*100)))/100;
	  }
}
