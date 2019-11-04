package Satellite_Control;

import GenCol.entity;

public class MessageSatelliteControl extends entity{
	
	String name = "MessageSatelliteControl";
	double procTime = 12;
	boolean isAlarmMessage = false;

	public MessageSatelliteControl(String nm, double pTime, boolean isAlarmMes){
		super(nm);
		name = nm;
		procTime=pTime;
		isAlarmMessage = isAlarmMes;
	}
	
	  public String toString(){
		  return name+"_"+(double)((int)(procTime*100))/100;
	  }
}
