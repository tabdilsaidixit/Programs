import java.util.*;
public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        
    	List<Integer> intList = new ArrayList<Integer>();
    	getNodes(root, intList);
    	
    	
    	
    	return intList;
    }
    
    public void getNodes(TreeNode root,List<Integer> list ) {
    	    	
    	
    	if(root!=null) {
    		if(root.left!=null) {
    			getNodes( root.left,list ) ;
    		}
    		
    		list.add(root.val);
    		if(root.right!=null) {
    			getNodes( root.right,list ) ;
    		}
    	}
    }
}
