import java.util.Arrays;

public class CheckPossibility {
	
	public String defangIPaddr(String address) {
		
		char[] chrArr = address.toCharArray();
		for(int i=0; i<chrArr.length; i++) {
			if(chrArr[i]>='A'&&chrArr[i]<='Z') {
				chrArr[i] += 32;
			}
		}
		return new String(chrArr);
    }
	public int rob(int[] nums) {
        if(nums.length == 0 || nums==null){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        else if(nums.length  == 2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        else{
            int max1 = robMax(nums, 0);
            int max2 = robMax(nums, 1);
            System.out.println("Max1: "+max1);
            System.out.println("Max2: "+max2);
            return max1>max2?max1:max2;
        }
    }
    
    public int robMax(int[] nums, int start){
    	if(nums.length - start <= 0) {
    		return 0;
    	}
    	
        if(nums.length - start == 1){
            return nums[start];
        }
        else if(nums.length - start == 2){
            return nums[start]>nums[start+1]?nums[start]:nums[start+1];
        }
        else{
            return Math.max(nums[start]+ robMax(nums, start+2), nums[start]+ robMax(nums, start+3));
        }
    }
    
	
	public int findUnsortedSubarray(int[] nums) {
        
		int[] dup = Arrays.copyOf(nums, nums.length);
		Arrays.sort(dup);	
		//System.out.println(Arrays.toString(nums));
		//System.out.println(Arrays.toString(dup));
		int start =0;
		int end = nums.length-1;
		while(start<=end && nums[start] == dup[start] ) {
			start++;
		}
		
		//System.out.print(start);
		//System.out.print("End" + end);
		
		while(end>start && nums[end] == dup[end] ) {
			end--;
		}
		System.out.print(end);
		
		
		return end-start+1 ;
    }
    public boolean checkPossibility(int[] nums) {
        int numberOfVariations =0;
        if(nums.length<=2){
            return true;
        }
        for(int i=0; i<nums.length-1; i++){
            
            if(nums[i]>nums[i+1] ){
            	//System.out.println(nums[i]);
                numberOfVariations++;
                if(numberOfVariations>1){
                    return false;
                }
                if(i>0) {
                	if(nums[i-1]<=nums[i+1])
                	{
                		nums[i] = nums[i-1];
                	}
                	else {
                		 nums[i+1] = nums[i];
                	}
                }
            	
                
            }
        }
        //System.out.println(numberOfVariations);
        return true;
    }
		
	public static void main(String[] args) {
		System.out.println(new CheckPossibility().defangIPaddr("Abc"));
	}
}
