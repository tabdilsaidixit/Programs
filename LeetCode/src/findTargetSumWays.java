
import java.util.*;

public class findTargetSumWays {

	public int findTargetSumWays(int[] nums, int S) {
    
		int count =0;
		if(nums==null||nums.length == 0) {
			return count;
		}
		
		int[] list = new int[nums.length];
		
		for(int i= nums.length-1; i>=0; i--) {
			for(int j=i; j<nums.length; j++) {
				list[j] = list[j]+nums[i];
			}
			for(int j=i; j<nums.length; j++) {
				if(list[j] ==S) {
					count++;
				}
			}
		}
		
		return count;
    }
	
	public static void main(String[] args) {
		new findTargetSumWays().findTargetSumWays(new int[] {1,1,1,1,1}, 3);
		
	}
}

