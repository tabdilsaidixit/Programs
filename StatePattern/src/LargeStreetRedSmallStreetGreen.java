
public class LargeStreetRedSmallStreetGreen implements TrafficControllerState {
	TrafficControllerStateContext context;
	public LargeStreetRedSmallStreetGreen(TrafficControllerStateContext context) {
		System.out.println("In LargeStreetRedSmallStreetGreen");
		this.context = context;
		setAndStartTimer(120);
	}
	@Override
	public void setVehicleAtSmallStreet(boolean isVehicleAtSmallStreet) {
		if(!isVehicleAtSmallStreet||context.getIsVehicleAtSmallStreet()) {
			context.setState(new LargeStreetRedSmallStreetOrange(context));
		}
	}
	@Override
	public void setAndStartTimer(int time) {
		int timer = time;	
		try {
			for(int i=0; i< time; i++)
			{
	            Thread.sleep(1000);
	            timer--;
			}
         } catch (Exception e) {
            System.out.println(e);
         }
		if(timer<=0) {
			context.setState(new LargeStreetRedSmallStreetOrange(context));
		}

	}
	@Override
	public void setEmergency(boolean isEmergency) {
		if(isEmergency==true) {
			context.setState(new EmergencyLargeStreetRedSmallStreetRed(context));
		}	
	}

}
