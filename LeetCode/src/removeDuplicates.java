
public class removeDuplicates {
	public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int index=0;
        int num = nums[0];
        for(int i=0; i<nums.length; i++){
            while(i<nums.length&&num ==nums[i]){
                i++;
            }
            nums[index]=num;
            index++;
            if(i<nums.length)
            {
                num = nums[i];
            }
            
            i--;
        }
        return index;
    }
	
	public static void main(String[] args) {
		new removeDuplicates().removeDuplicates(null);
	}

}
