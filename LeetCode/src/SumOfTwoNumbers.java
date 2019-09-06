import java.util.HashMap;

public class SumOfTwoNumbers {
	
	public static int[] twoSum(int[] nums, int target) {
		
		int lengthOfArray = nums.length;
		HashMap<Integer, Integer>hashMap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<lengthOfArray;i++)
		{
			int required = target-nums[i];
			
			if(hashMap.containsKey(required)&&hashMap.get(required)!=i)
			{
				
				return new int[] {i,hashMap.get(required)};
			}
			hashMap.put(nums[i], i);
		}
        
		return null;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {-10,-1,-18,-19};
		int target = -19;
		int[] s = twoSum(nums, target);
		
	}

}
