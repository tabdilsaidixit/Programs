
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] integerArray= new int[] {-1, -1};
        
        int start = 0;
        int end = nums.length -1;
        int index = -1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(nums[mid] == target) {
				index =mid;
				break;
			}
			else if(nums[mid] > target) {
				end = mid -1;
			}
			else {
				start = mid+1;
			}
		}
		if(index == -1) {
			return integerArray;
		}
		
		int startIndex = index;
		int s = index;
		int e = index;
		while(startIndex>=0 && nums[startIndex] == target ) {
			s = startIndex;
			startIndex--;
		}
		int endIndex = index;
		while(endIndex<nums.length && nums[endIndex] == target) {
			e = endIndex;
			endIndex++;
		}
		integerArray[0] = s;
		integerArray[1] = e;
		
        return integerArray;
    }

public static void main(String[] args) {
	new searchRange().searchRange(new int[] {1}, 1);
}
}
