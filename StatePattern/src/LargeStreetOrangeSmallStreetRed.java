
public class LargeStreetOrangeSmallStreetRed implements TrafficControllerState {

	TrafficControllerStateContext context;
	
	public LargeStreetOrangeSmallStreetRed(TrafficControllerStateContext context){
		System.out.println("In LargeStreetOrangeSmallStreetRed");
		this.context = context;
		setAndStartTimer(10);
	}
	@Override
	public void setVehicleAtSmallStreet(boolean isVehicleAtSmallStreet) {
		System.out.println("It stays in same state");		
	}
	@Override
	public void setAndStartTimer(int time) {
		int timer = time;
		
		try {
			for(int i=0; i< time; i++)
			{
	            // thread to sleep for 1000 milliseconds
	            Thread.sleep(1000);
	            timer--;
			}
         } catch (Exception e) {
            System.out.println(e);
         }
		if(timer<=0) {
			context.setState(new LargeStreetRedSmallStreetGreen(context));
		}
		
	}
	@Override
	public void setEmergency(boolean isEmergency) {
		if(isEmergency==true) {
			context.setState(new EmergencyLargeStreetRedSmallStreetRed(context));
		}		
	}
	
}
