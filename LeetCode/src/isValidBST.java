import java.util.ArrayList;
import java.util.List;

public class isValidBST {
	public boolean isValidBST(TreeNode root) {
        
		   
    	List<Integer> intList = new ArrayList<Integer>();
    	getNodes(root, intList);
    	
    	for(int i=0; i<=intList.size(); i++) {
    		if(intList.get(i)>intList.get(i+1)) {
    			return false;
    		}
    	}
    	
    	return true;
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
