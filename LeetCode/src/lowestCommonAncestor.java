import java.util.*;

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root==null||p==null||q==null) {
    		return null;
    	}
    	
    	HashMap<Integer, TreeNode> list = new HashMap<Integer, TreeNode>();
    	lowestCommonAncestor(root, p, q, list, 1);
    	int found = 0;
    	for(Integer currentHeight: list.keySet()) {
    		if(currentHeight>found) {
    			found = currentHeight;
    		}
    	}
        return list.get(found);
    }
    
    void lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, HashMap<Integer, TreeNode> list, int height) {
    	if(root.left !=null) {
    		lowestCommonAncestor(root.left, p, q, list, ++height);
    	}
    	if(root.right !=null) {
    		lowestCommonAncestor(root.right, p, q, list, ++height);
    	}
    	boolean found = false;
    	for(Integer currentHeight: list.keySet()) {
    		if(currentHeight>height) {
    			found = true;
    			break;
    		}
    	}
    	if(found) {
    		return;
    	}
    	boolean findP =false;
    	boolean findQ = false;
    	Stack<TreeNode> treeNodes = new Stack<TreeNode>();
    	treeNodes.add(root);
    	while(!treeNodes.isEmpty()) {
    		TreeNode popedNode = treeNodes.pop();
    		if(popedNode.val==p.val) {
    			findP = true;
    		}
    		else if(popedNode.val==q.val) {
    			findQ = true;
    		}
    		
    		if(findP&&findQ) {
    			list.put(height, root);
    		}
    		if(popedNode.left !=null) {
    			treeNodes.push(popedNode.left);
        	}
        	if(popedNode.right !=null) {
        		treeNodes.push(popedNode.right);
        	}
    		
    	}
    	
    	
    }
    
    
}
