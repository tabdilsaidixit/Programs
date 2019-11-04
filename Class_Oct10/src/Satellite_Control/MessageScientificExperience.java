package Satellite_Control;

import GenCol.entity;

public class MessageScientificExperience extends entity{
	
	String name = "ScientificExperience";
	double procTime = 12;

	public MessageScientificExperience(String nm, double pTime){
		super(nm);
		name = nm;
		procTime=pTime;
	}
	
	  public String toString(){
		  return name+"_"+(double)((int)(procTime*100))/100;
	  }
}
