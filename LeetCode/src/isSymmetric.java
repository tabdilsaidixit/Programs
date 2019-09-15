import java.util.ArrayList;
import java.util.List;

public class isSymmetric {
        public boolean isSymmetric(TreeNode root) {
    	 List<TreeNode> arr= new ArrayList<TreeNode>();
    	 
    	getInorderTraversal(root, arr);
    	
    	for(int i=0; i< arr.size()/2; i++) {
    		
    		if(arr.get(i)!=null && arr.get(arr.size()-i-1)!=null ) {
    			if(arr.get(i).val!=arr.get(arr.size()-i-1).val) {
    				return false;
    			}
    		}
    		else if(!(arr.get(i)==null && arr.get(arr.size()-i-1)==null)) {
    			return false;
    		}
    	}
    	for(TreeNode x: arr) {
    		if(x!=null) {
    			System.out.print(x.val + "  ");
    		}
    		else {
    			System.out.print( " null ");
    		}
    	}
    	
    	
    	
    	return true;
    }
    
    public void getInorderTraversal(TreeNode root, List<TreeNode> treeNodesList){
    	
    	if(root!=null) {
            if(root.left!=null){
                getInorderTraversal(root.left, treeNodesList);
            }
    		
    		treeNodesList.add(root);
            
            if(root.right!=null){
                getInorderTraversal(root.right, treeNodesList);
            }
    		
    	}
    	else {
    		treeNodesList.add(root);
    	}
    	
    }
    
    
}
