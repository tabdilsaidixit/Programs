
public class lengthOfLIS {

    public int lengthOfLIS(int[] nums) {
    	if(nums== null || nums.length ==0) {
    		return 0;
    	}
    	if(nums.length == 1) {
    		return 1;
    	}
    	
    	int[] maxSubArrayLength = new int[nums.length]; 
    	for(int i= nums.length-1; i>=0; i--) {
    		int max =0;
    		for(int j=i+1; j<maxSubArrayLength.length ; j++) {
    			if(nums[i]<nums[j]) {
    				if(maxSubArrayLength[j]>max) {
        				max = maxSubArrayLength[j]; 
        			}
    			}
    		}
    		maxSubArrayLength[i] = max+1;
    	}
    	
    	int m =0;
    	for(int j=0; j<maxSubArrayLength.length ; j++) {
			if(maxSubArrayLength[j]>m) {
				m = maxSubArrayLength[j];
			}
		}
        return m;
    }
    public static void main(String[] args) {
		System.out.println( new lengthOfLIS().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18,111}));
	}
}
