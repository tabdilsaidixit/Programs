import java.util.*;


public class Duplicate {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		int[]  leftright= new int[rows];
		int[] topbottom = new int[cols];
		for(int i=0; i<rows; i++)
		{
			int max =0;
			for(int j=0; j<cols; j++)
			{
				if(grid[i][j]>max)
				{
					max = grid[i][j];
				}
				
			}
			leftright[i] = max;
		}
		
		for(int i=0; i<cols; i++)
		{
			int max =0;
			for(int j=0; j<rows; j++)
			{
				if(grid[j][i]>max)
				{
					max = grid[j][i];
				}
				
			}
			topbottom[i] = max;
		}
		
		int total =0;
		
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				int c = Math.min(leftright[i], topbottom[j]) - grid[i][j];
				if(c>0)
				total+=c;
				
				
			}
		}
		
	        return total;
	    }
	
	 public List<Integer> findDuplicates(int[] nums) {
		 List<Integer> res = new ArrayList<>();
	        for (int i = 0; i < nums.length; ++i) {
	            
	        	
	        	
	        	int index = Math.abs(nums[i])-1;
	            
	        	System.out.println(index);
	        	System.out.println(nums[index]);
	            
	            if (nums[index] < 0)
	                res.add(Math.abs(index+1));
	            
	            nums[index] = -nums[index];
	        }
	        return res;
	        
	    }
	 public static void main(String[] args) {
		Duplicate duplicate = new Duplicate();
		int[][] gridNew = new int[][] { {3,0,8,4},
		            {2,4,5,7},
		            {9,2,6,3},
		            {0,3,1,0} };
		int t = duplicate.maxIncreaseKeepingSkyline(gridNew);
		System.out.println(t);
	}

}
