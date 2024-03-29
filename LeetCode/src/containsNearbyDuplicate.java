import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class containsNearbyDuplicate {
	public boolean containsNearbyDuplicate1(int[] nums, int k) {
        
		if(nums.length<2) {
			return false;
		}
		
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<=i+k&&j<nums.length;j++) {
				if(nums[i]==nums[j]) {
					return true;
				}
			}
		}
		
		
		return false;
    }
public boolean containsNearbyDuplicate(int[] nums, int k) {
		

		if(nums.length<2) {
			return false;
		}
		Set<Integer> hashSet = new HashSet<Integer>();
		
		for(int i=0; i<nums.length; i++) {
			if(i>k) {
				hashSet.remove(nums[i-k-1]);
			}
			if(!hashSet.add(nums[i])) {
				return true;
			}
		}
		
		return false;
    }
	
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		

		if(nums.length<2) {
			return false;
		}
		
		Queue<Integer> bufferQueue = new LinkedList<Integer>();
		
		for(int j=1; j<=k&&j<nums.length;j++) {
			bufferQueue.add(nums[j]);
		}
        
		
		for(int i=0; i<nums.length-1; i++) {
			if(bufferQueue.contains(nums[i])) {
				return true;
			}
			else {
				bufferQueue.remove();
				if(i+k+1<nums.length) {
					bufferQueue.add(nums[i+k+1]);
				}
			}
		}
		
		
		return false;
    }
	public static void main(String[] args) {
		System.out.print(new containsNearbyDuplicate().containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
	}
}
