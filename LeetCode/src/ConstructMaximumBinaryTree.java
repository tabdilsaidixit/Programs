import java.util.Arrays;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {    	
    	int max = Integer.MIN_VALUE;
    	int max_index = -1;
    	for(int i =0; i<nums.length;i++)
    	{
    		if(nums[i]>max)
    		{
    			max = nums[i];
    			max_index = i;
    		}
    	}
    	TreeNode root = null;
    	if(max_index>-1&& max>Integer.MIN_VALUE)
    	{
    		int[] leftArray = Arrays.copyOfRange(nums, 0, max_index);
    		int[] rightArray = Arrays.copyOfRange(nums, max_index+1, nums.length);
    		root = new TreeNode(max);
    		root.left = constructMaximumBinaryTree(leftArray);
    		root.right = constructMaximumBinaryTree(rightArray);
    	}
    	return root;
    }
    
    public static void main(String[] args) {
		TreeNode c = new ConstructMaximumBinaryTree().constructMaximumBinaryTree(new int[] {3,2,1,6,0,5});
		
		System.out.print(c);
	}

}
