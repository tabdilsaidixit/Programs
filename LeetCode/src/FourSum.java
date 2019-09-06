import java.util.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FourSum {
	
	public static boolean contains(int[] arr, int item) {
	      for (int n : arr) {
	         if (item == n) {
	            return true;
	         }
	      }
	      return false;
	   }
	 public static int[] remove(int[] a, int index) {
	        if (a == null || index < 0 || index >= a.length) {
	            return a;
	        }
	 
	        int[] result = new int[a.length - 1];
	 
	        System.arraycopy(a, 0, result, 0, index);
	        System.arraycopy(a, index + 1, result, index, a.length - index - 1);
	 
	        return result;
	    }
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		
		List<List<Integer>> listOfQuadraples = new ArrayList<List<Integer>>();
		
		
		for(int i=0; i<nums.length-3;i++)
		{
			for(int j=i+1;j<nums.length-2;j++)
			{
				for(int k = j+1; k<nums.length-1;k++)
				{
					int sum = nums[i]+nums[j]+nums[k];
					int last = target-sum;
					int[] test = nums;
					test = remove(test,k);
					test = remove(test,j);
					test = remove(test,i);
					if(contains(test,last))
					{
						int[] arr = new int[] {nums[i], nums[j], nums[k], last};	
						
						Arrays.sort(arr);
						boolean add = true;
						for(List<Integer> curList : listOfQuadraples)
						{
							int[] t = curList.stream().mapToInt(f->f).toArray();
							boolean first = arr[0]==t[0]?true:false;
							boolean second = arr[1]==t[1]?true:false;
							boolean third = arr[2]==t[2]?true:false;
							boolean fourth = arr[3]==t[3]?true:false;
							if((first&&second&&third&&fourth))
							{
								add = false;
								break;
							}
						}
						if(add)
						{
							List<Integer> temp = new ArrayList<Integer>();
							for(int x =0; x<4;x++)
							{
								temp.add(arr[x]);
							}
							listOfQuadraples.add(temp);
						}
						
					}
					
				}
			}
		}
		
		
		return listOfQuadraples;
        
    }
	
	public static void main(String[] args) {
		
		FourSum objFourSum = new FourSum();
		objFourSum.fourSum(new int[] {1,0,-1,0,-2,2}, 0);
		
	}

}
