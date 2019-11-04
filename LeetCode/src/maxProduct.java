import java.util.ArrayList;
import java.util.List;

public class maxProduct {
	
	public int maxProduct(int[] nums) {
		 if(nums==null || nums.length==0) {
				return 0;
			}
		 int maximum = nums[0];
			
         int preMax = nums[0];
         int preMin = nums[0];
         
         int maxhere, minhere;
         for(int i =1; i<nums.length; i++) {

        	 maxhere = Math.max(nums[i], Math.max(preMax * nums[i],preMin* nums[i] ) );
        	 minhere = Math.min(nums[i], Math.min(preMax * nums[i],preMin* nums[i] ) );
             if(maxhere> maximum) {
                 maximum = maxhere;
             }
             preMax = maxhere;
             
             preMin = minhere;
             
             
         }

         return maximum;
    }
	
	public static void main(String[] args) {
		System.out.println(new maxProduct().maxProduct(new int[] {2,-5,-2,-4,3})); 
	}
}
