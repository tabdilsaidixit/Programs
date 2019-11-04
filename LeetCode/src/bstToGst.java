import java.util.LinkedList;
import java.util.Queue;

public class bstToGst {
    public TreeNode bstToGst(TreeNode root) {
    	
    	Queue<TreeNode> treeNodes = new LinkedList<TreeNode>();
    	if(root!=null) {
    		bstToGst(root,treeNodes);
    	}
    	int sum =0;
    	
    	while(!treeNodes.isEmpty()) {
    		TreeNode top = treeNodes.poll();
    		sum = sum+top.val;
    		top.val=sum;
    	
    	}
    	
    	
    	return root;
        
    }
    void bstToGst(TreeNode root, Queue<TreeNode> treeNodes) {
    	
    	if(root.right!=null) {
        	bstToGst(root.right, treeNodes);	
    	}
    	
    	treeNodes.add(root);
    	
    	if(root.left!=null) {
        	bstToGst(root.left, treeNodes);	
    	}

    }
}
