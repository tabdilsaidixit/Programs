import java.util.HashMap;

public class rob {

	public int rob(int[] nums) {
        if(nums==null||nums.length==0) {
			return 0;
		}
		if(nums.length==1) {
			return nums[0];
		}
		if(nums.length==2) {
			if(nums[0]>nums[1]) {
				return nums[0];
			}
			else {
				return nums[1];
			}
		}
		int[] maxArray = new int[nums.length];
		int m=0;
		for(int i=nums.length-1 ; i>=0; i--) {
			int mx =0;
			int mx1 =0;
			int mx2=0;
			if(i+2<nums.length && i+i+2!=nums.length-1) {
				mx1 = maxArray[i+2];
			}
			if(i+3<nums.length&& i+i+3!=nums.length-1) {
				mx2 = maxArray[i+3];
			}
			
			if(mx1>mx2) {
				maxArray[i] = nums[i]+mx1;
			}
			else {
				maxArray[i] = nums[i]+mx2;
			}
		}
		if(maxArray[0]>maxArray[1]) {
			m = maxArray[0];
		}
		else {
			m = maxArray[1];
		}
		return m;
    }

	public int rob1(int[] nums) {
		if(nums==null||nums.length==0) {
			return 0;
		}
		if(nums.length==1) {
			return nums[0];
		}
		if(nums.length==2) {
			if(nums[0]>nums[1]) {
				return nums[0];
			}
			else {
				return nums[1];
			}
		}
		int[] maxArray = new int[nums.length];
		int m=0;
		for(int i=nums.length-1 ; i>=0; i--) {
			int mx =0;
			int mx1 =0;
			int mx2=0;
			if(i+2<nums.length) {
				mx1 = maxArray[i+2];
			}
			if(i+3<nums.length) {
				mx2 = maxArray[i+3];
			}
			
			if(mx1>mx2) {
				maxArray[i] = nums[i]+mx1;
			}
			else {
				maxArray[i] = nums[i]+mx2;
			}
		}
		if(maxArray[0]>maxArray[2]) {
			m = maxArray[0];
		}
		else {
			m = maxArray[1];
		}
		return m;
    }
    
       
    public int robMax(int[] nums, int start, HashMap<Integer, Integer> hashMap){
    	if(hashMap.containsKey(start)) {
    		return hashMap.get(start);
    	}
    	if(nums.length - start <= 0) {
    		hashMap.put(start, 0);
    		return 0;
    	}
    	
        if(nums.length - start == 1){
        	hashMap.put(start, nums[start]);
            return nums[start];
        }
        else if(nums.length - start == 2){
        	hashMap.put(start, nums[start]>nums[start+1]?nums[start]:nums[start+1]);
            return nums[start]>nums[start+1]?nums[start]:nums[start+1];
        }
        else{
            return Math.max(nums[start]+ robMax(nums, start+2, hashMap), nums[start]+ robMax(nums, start+3, hashMap));
        }
    }
    
    public static void main(String[] args) {
		new rob().rob(new int[] {2,7,9,3,1});
	}
}
