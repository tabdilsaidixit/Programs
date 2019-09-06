import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer>  newL = new ArrayList<Integer>();
    	
    	int[] newArray= new int[nums.length];
    	for(int i=0; i<nums.length;i++) {
    		newArray[nums[i]-1] = 5;
    	}
    	for(int i=0; i<nums.length;i++) {
    		if(newArray[i] != 5) {
    			newL.add(i+1);
    		}
    	}    	
    	
        return newL ; 
     }
    public static void main(String[] args) {
    	List<Integer> n = new findDisappearedNumbers().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
    	System.out.println(n);
	}
}
