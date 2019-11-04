import java.util.LinkedList;

public class flatten {
	 public void flatten(TreeNode root) {
	        LinkedList<TreeNode> list  = new LinkedList<TreeNode>();
	        flatten(root, list);
	        TreeNode rootDup = root;
	        while(!list.isEmpty()) {
	        	TreeNode temp = list.poll();
	        	rootDup = temp;
	        	rootDup.left = null;
	        	rootDup.right = rootDup;
	        }
	        rootDup.right = null;
	        rootDup.left = null;
	 }

	private void flatten(TreeNode root, LinkedList<TreeNode> list) {
		// TODO Auto-generated method stub
		if(root!=null) {
			flatten(root.left, list);
			list.add(root);
			flatten(root.right, list);
		}
	}
	 
	 
}
