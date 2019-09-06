
public class carPooling {
	public boolean carPooling(int[][] trips, int capacity) {
		int numberOfTrips = trips.length;
		int start =trips[0][1];
		int end=0;
		for(int tripNumber = 0; tripNumber<numberOfTrips; tripNumber++) {
			if(trips[tripNumber].length!=3)
			{
				return false;
			}
			if(trips[tripNumber][2]<trips[tripNumber][1]) {
				return false;
			}
			if(start>trips[tripNumber][1]) {
				start = trips[tripNumber][1];
			}
			if(end<trips[tripNumber][2]) {
				end = trips[tripNumber][2];
			}			
		}
		
		int[] stopNumberCapacity = new int[end];
		for(int i=0; i<end; i++) {
			stopNumberCapacity[i] = capacity;
		}

		for(int tripNumber = 0; tripNumber<numberOfTrips; tripNumber++) {
			for(int i = trips[tripNumber][1] ;i<trips[tripNumber][2]; i++ ) {
				stopNumberCapacity[i]-=trips[tripNumber][0];
			}			
		}
		
		for(int i=0; i<end; i++) {
			if(stopNumberCapacity[i] <0)
			{
				return false;
			}
		}
		
		return true;
        
    }
	public static void main(String[] args) {
		int[][] trips = new int[][] {{2,1,5},{3,3,7}};
		System.out.println(new carPooling().carPooling(trips, 4));
	}

}
