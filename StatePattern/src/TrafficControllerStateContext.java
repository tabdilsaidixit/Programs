
public class TrafficControllerStateContext {
	TrafficControllerState trafficControllerState;
	boolean vehicleOnSmallStreet =false;
	
	public TrafficControllerStateContext(){
		trafficControllerState = new LargeStreetGreenSmallStreetRed(this);
	}
	
	public void setEmergency(boolean emer) {
		trafficControllerState.setEmergency(emer);
	}
	
	public void vehicleOnSmallStreet(boolean isVehPresent) {
		vehicleOnSmallStreet = isVehPresent;
		trafficControllerState.setVehicleAtSmallStreet(isVehPresent);
	}
	
	public void setState(TrafficControllerState trafficContState) {
		trafficControllerState = trafficContState;
	}

	public boolean getIsVehicleAtSmallStreet() {
		return vehicleOnSmallStreet;
	}	

}
