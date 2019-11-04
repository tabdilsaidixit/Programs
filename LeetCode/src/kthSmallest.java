import java.util.*;
public class kthSmallest {

	public int kthSmallest(TreeNode root, int k) {
		if(root==null) {
			return 0;
		}
		
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        kthSmallest(root, arrlist);
       
		return arrlist.get(k-1);
    }
	void kthSmallest(TreeNode root, ArrayList<Integer> arrlist) {
		if(root!=null) {
			arrlist.add(root.val);
			kthSmallest(root.right, arrlist);
			kthSmallest(root.left, arrlist);
		}
	}
	
	 public int kthSmallest(int[][] matrix, int k) {
	        if(k<1){
	            return 0;
	        }
	        int numberOfRows = matrix.length;
	        int numberOfColumns = matrix[0].length;
	        int index= k-1;
	        int colNumber = index%numberOfColumns;
	        int rowNumber = index/numberOfColumns;
	        if(numberOfRows ==1){
	            rowNumber = 0;
	        }
	        
	        return matrix[rowNumber][colNumber];
	        
	    }
	 public static void main(String[] args) {
		System.out.println(new kthSmallest().kthSmallest(new int[][] {{-5}},1));
	}
}
