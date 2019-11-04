
public class Client {
	public static void main(String[] args) {
		TrafficControllerStateContext stateContext = new TrafficControllerStateContext();
		stateContext.vehicleOnSmallStreet(true);
		stateContext.setEmergency(true);
		stateContext.vehicleOnSmallStreet(false);
		stateContext.setEmergency(false);
	}

}
