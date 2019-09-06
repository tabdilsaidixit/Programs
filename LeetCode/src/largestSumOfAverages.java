import java.util.Arrays;

public class largestSumOfAverages {
	
public double largestSumOfAverages(int[] A, int K) {
	
	if(K<=0)
	{
		return 0;
	}
	Arrays.sort(A);
	int end = A.length - K+1;
	double sum = 0;
	for(int i=0; i<end;i++)
	{
		sum+=A[i];
	}
	
	double other = 0;
	
	for(int i=end; i<A.length;i++)
	{
		other+=A[i];
	}
	
	double avg = sum/end + other ;
	return avg;
        
    }
 public static void main(String[] args) {
	double maxAvg = new largestSumOfAverages().largestSumOfAverages(new int[] {4,1,7,5,6,2,3},4);
	System.out.print(maxAvg);
}

}
