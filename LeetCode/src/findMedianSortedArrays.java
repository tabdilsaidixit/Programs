

public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	
    	int[] newArray = new int[nums1.length+nums2.length];
    	int index =0;
    	int nums1Index =0, nums2Index=0;
    	while(nums1Index<nums1.length&&nums2Index<nums2.length) {
    		if(nums1[nums1Index]<nums2[nums2Index]) {
    			newArray[index] = nums1[nums1Index];
    			nums1Index++;
    		}
    		else {
    			newArray[index] =nums2[nums2Index];
    			nums2Index++;
    		}
    		index++;
    	}
    	while(nums1Index<nums1.length) {	
			newArray[index] = nums1[nums1Index];
			nums1Index++;
    		index++;
    	}
    	while(nums2Index<nums2.length) {	
			newArray[index] =nums2[nums2Index];
			nums2Index++;
    		index++;
    	}
    	int mid = newArray.length/2;
    	if(newArray.length%2==1) {
    		return newArray[mid];
    	}
    	else {
    		return (newArray[mid]+ newArray[mid-1])/2;
    	}
    }
	
	
	 public static void main(String[] args) {
		System.out.println("T");
	}
}
