import java.util.LinkedList;
import java.util.Queue;

public class RotateArray {
	
	public void rotate1(int[] nums, int k) {
        if(nums.length<2) {
        	return;
        }
        int numberOfRotations = k%nums.length;
        for(int i=1; i<=numberOfRotations;i++) {
        	rotate(nums);
        }
    }
	
	public void rotate(int[] nums) {
		int temp = nums[nums.length-1];
		for(int i=nums.length-1; i>0;i--) {
			nums[i] = nums[i-1];
		}
		nums[0] = temp;
	}
	
	public void rotate(int[] nums, int k) {
		int lengthOfArray = nums.length;
		
		if(lengthOfArray<2) {
        	return;
        	
        }
        int numberOfRotations = k%lengthOfArray;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i = lengthOfArray-1; i>lengthOfArray-numberOfRotations-1; i--) {
        	queue.add(nums[i]);
        }
        
        for(int i=0; i<lengthOfArray-numberOfRotations; i++) {
        	nums[i+numberOfRotations] = nums[i];
        }
        
        for(int i = numberOfRotations-1; i>=0; i--) {
        	nums[i] = queue.remove();
        }
        
    }
	

}
