import java.util.ArrayList;
import java.util.Comparator;

public class convertBST {
	 public TreeNode convertBST(TreeNode root) {
		 if(root!=null) {
			 root.val +=  getNewValue(root, root.val);
			 convertBST(root.left);
			 convertBST(root.right);
		 }
		 
		 return root;
	 }
	 
	 public int getNewValue(TreeNode root, int nodeValue) {
		 int val = 0;
		 if(root!=null) {
			 if(root.val>nodeValue) {
				 val+=root.val;
			 }
			 val+=getNewValue(root.left, nodeValue);
			 val+=getNewValue(root.right, nodeValue);
		 }
		 
		 return val;
	 }
    public TreeNode convertBST1(TreeNode root) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	getElements(root, arr);
    	if(root!=null) {
    		arr.add(root.val);
    		
    	}
    	
    	
    	
    	return root;
        
    }
    
    public void getElements(TreeNode root, ArrayList<Integer> arrList) {
    	if(root!=null) {
    		arrList.add(root.val);
    		getElements(root.left, arrList);
    		getElements(root.right, arrList);

    	}
    }

}
