
public class singleNonDuplicate {
	public int singleNonDuplicate(int[] nums) {
		return singleNonDuplicate(nums, 0,nums.length-1 );
    }
	
	public int singleNonDuplicate(int[] nums, int start, int end)
	{
		int mid = (start+end)/2;
		if( start==end||!(nums[mid]== nums[mid-1] || nums[mid]== nums[mid+1] ))
		{
			return nums[mid];
		}
		else if(nums[mid]== nums[mid-1])
		{
			if(mid%2==0) {
				end =  mid-2;
			}
			else {
				start = mid+1;
			}
		}
		else {
			if(mid%2==0) {
				start = mid+2;
			}
			else {
				end = mid-1;		
			}
		}
		return singleNonDuplicate(nums,start,end);
	}
	
	public static void main(String[] args) {
		singleNonDuplicate s = new singleNonDuplicate();
		int[] a = {1};
		
		int x = s.singleNonDuplicate(a);
		System.out.print(x);
		
	}
}

