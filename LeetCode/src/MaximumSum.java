
public class MaximumSum {
    public int maximumSum(int[] arr) {
    	if(arr.length==0) {
    		return 0;
    	}
    	if(arr.length==1) {
    		return arr[0];
    	}
        int totalMax =Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++){
            int max = maximumSkipIndex(arr,i);
            if(max>totalMax){
                totalMax= max; 
            }
        }
        return totalMax;
    }
    
    public int maximumSkipIndex(int[] arr, int skipIndex){
        int currentMax = 0;
        int totalMax =Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++){
            if(i==skipIndex){
                continue;
            }
            currentMax = Math.max(arr[i], currentMax+arr[i]);
            if(totalMax<currentMax){
                totalMax=currentMax;
            }
        }
        return totalMax;
    }
    
    public static void main(String[] args) {
		System.out.println(new MaximumSum().maximumSum(new int[] {-1,-1,-1,-1}));
	}
}
