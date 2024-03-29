import java.util.*;
public class containsDuplicate {
    public boolean containsDuplicate1(int[] nums) {
        
    	Arrays.sort(nums);
    	
    	for(int i=0; i<nums.length-1;i++) {
    		if(nums[i] == nums[i+1]) {
    			return true;
    		}
    	}
    	
    	
    	return false;
    }
    
    public boolean containsDuplicate(int[] nums) {
        
    	Set<Integer> hashSet = new HashSet<Integer>();
    	
    	
    	for(int i=0; i<nums.length;i++) {
    		if(hashSet.contains(nums[i])) {
    			return true;
    		}
    		hashSet.add(nums[i]);
    	}
    	
    	
    	return false;
    }
    
    public static void main(String[] args) {
		System.out.print(new containsDuplicate().containsDuplicate(new int[] {1,2,3,1}));
	}
    
    
}
