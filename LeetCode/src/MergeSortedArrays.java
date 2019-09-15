
public class MergeSortedArrays {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m+n];
        
        int index =0;
        int p_nums1=0;
        int p_nums2=0;
        while(p_nums1<nums1.length&&p_nums2<nums2.length) {
        	if(nums1[p_nums1]<nums2[p_nums2]) {
        		mergedArray[index] = nums1[p_nums1];
        		p_nums1++;
        	}
        	else {
        		mergedArray[index] = nums1[p_nums2];
        		p_nums2++;
        	}
        	index++;
        }
        
        while(p_nums1<nums1.length) {
        	mergedArray[index] = nums1[p_nums1];
        	p_nums1++;
        	index++;
        }
        
        while(p_nums2<nums2.length) {
        	mergedArray[index] = nums2[p_nums1];
        	p_nums2++;
        	index++;
        }
    }
	
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m+n];
        
        int index =0;
        int p_nums1=0;
        int p_nums2=0;
        while(p_nums1<nums1.length&&p_nums2<nums2.length) {
        	if(nums1[p_nums1]<nums2[p_nums2]) {
        		mergedArray[index] = nums1[p_nums1];
        		p_nums1++;
        	}
        	else {
        		mergedArray[index] = nums1[p_nums2];
        		p_nums2++;
        	}
        	index++;
        }
        
        while(p_nums1<nums1.length) {
        	mergedArray[index] = nums1[p_nums1];
        	p_nums1++;
        	index++;
        }
        
        while(p_nums2<nums2.length) {
        	mergedArray[index] = nums2[p_nums1];
        	p_nums2++;
        	index++;
        }
    }
    
    
    public static void main(String[] args) {
		
	}
}
