
public class RotateArray {
	
	public void rotate(int[] nums, int k) {
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

}
