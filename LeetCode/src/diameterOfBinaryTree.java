import java.util.TreeSet;

public class diameterOfBinaryTree {
	 public int diameterOfBinaryTree(TreeNode root) {
	        
	        if(root==null){
	            return 0;
	        }
	        else{
	            
	            int rightHeight =0;
	            if(root.right!=null){
	                rightHeight = findHeight(root.right);
	            }
	            int leftHeight =0;
	            if(root.left!=null){
	                leftHeight = findHeight(root.left);
	            }
	            return Math.max(rightHeight+leftHeight,Math.max(diameterOfBinaryTree(root.right), diameterOfBinaryTree(root.left)));
	        }
	    }
	    
	     public int findHeight(TreeNode root ) {
	    	int currentHeight  = 1;    	
	    	int leftHeight = 0, rightHeight = 0;    	
	    	if(root.left!=null) {
	    		leftHeight=findHeight(root.left);
	    	}
	    	if(root.right!=null) {
	        	rightHeight=findHeight(root.right);    		
	    	}
	    	if(leftHeight>rightHeight) {
	    		currentHeight+=leftHeight;
	    	}
	    	else {
	    		currentHeight+=rightHeight;
	    	}
			return currentHeight ;
	        
	    }
	}
