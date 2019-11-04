
public class LargeStreetGreenSmallStreetRed implements TrafficControllerState {
	
	TrafficControllerStateContext context;
	public LargeStreetGreenSmallStreetRed(TrafficControllerStateContext context) {
		System.out.println("In LargeStreetGreenSmallStreetRed");
		this.context = context;
	}
	@Override
	public void setVehicleAtSmallStreet(boolean isVehicleAtSmallStreet) {
		if(isVehicleAtSmallStreet) {
			context.setState(new LargeStreetOrangeSmallStreetRed(context));
		}
	}

	@Override
	public void setAndStartTimer(int time) {
		System.out.print("There is no timer for LargeStreetGreenSmallStreetRed");
	}

	@Override
	public void setEmergency(boolean isEmergency) {
		if(isEmergency==true) {
			context.setState(new EmergencyLargeStreetRedSmallStreetRed(context));
		}
	}

}
