
public class distanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start<0||destination<0) {
        	return 0;
        }
        
        if(distance.length<1) {
        	return 0;
        }
        if(start>distance.length-1||destination>distance.length-1) {
        	return 0;
        }
        
        int totaldistance = 0;
        for(int i =0; i< distance.length; i++) {
        	totaldistance+=distance[i];
        }
        
        if(start>destination) {
        	int temp = start;
        	start = destination;
        	destination = temp;
        }
        int clock =0;
        for(int i=start; i<destination; i++) {
        	clock+=distance[i];
        }
        int antiClock = totaldistance-clock;
        return clock>antiClock?antiClock:clock;
        
    }
    
    public static void main(String[] args) {
		
	}
}
