import java.util.Arrays;
import java.util.HashMap;

public class majorityElement {
	
	  public int majorityElement(int[] nums) {

	    	 HashMap<Integer, Integer> freq = new HashMap<>(); 
	        
	        for(int i=0; i<nums.length; i++) {
	        	if(!freq.containsKey(nums[i])) {
	        		freq.put(nums[i], 1);
	        	}
	        	else {
	        		freq.put(nums[i], freq.get(nums[i]) + 1);
	        	}
	        }
	        for(Integer i:freq.keySet()) {
	        	if(freq.get(i)>(int)(Math.floor(nums.length/2))) {
	        		return i;
	        	}
	        }
	        return 0;
	    }
	  
    public int majorityElement1(int[] nums) {

        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
        	System.out.println(nums[i]);
        }
        
        int leastFreq = (int)Math.floor(nums.length/2);
        System.out.println("Least Freq -> "+leastFreq);
        int num=nums[0];
        
        for(int i=0; i<nums.length; i++) {
        	int freq =0;
        	while(i<nums.length&&nums[i] == num ) {
        		freq++;
        		i++;
        	}
        	System.out.println("Number :"+ num+"Freq ->"+freq);
        	if(freq>leastFreq) {
        		return num;
        	}
            if(i<nums.length)
            {
        	    num = nums[i] ;
            }
        	i--;
        }
        
        return 0;

    }
    public static void main(String[] args) {
		System.out.println(new majorityElement().majorityElement(new int[] {3,2,3}));
	}
}

