
public class EmergencyLargeStreetRedSmallStreetRed implements TrafficControllerState {
	TrafficControllerStateContext context ;
	public EmergencyLargeStreetRedSmallStreetRed(TrafficControllerStateContext context) {
		System.out.println("In EmergencyLargeStreetRedSmallStreetRed ");
		this.context = context;
	}
	@Override
	public void setVehicleAtSmallStreet(boolean isVehicleAtSmallStreet) {
		System.out.println("No change in state");
	}
	@Override
	public void setAndStartTimer(int time) {
		System.out.println("No change in state");
	}
	@Override
	public void setEmergency(boolean isEmergency) {
		if(!isEmergency) {
			if(context.getIsVehicleAtSmallStreet()) {
				context.setState(new LargeStreetRedSmallStreetGreen(context));
			}
			else {
				context.setState(new LargeStreetGreenSmallStreetRed(context));
			}
		}
	}

}
