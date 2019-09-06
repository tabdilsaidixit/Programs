
public class mergeTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		
		if(t1!=null && t2!=null) {
			t1.val = t1.val+t2.val;
		}
		else if(t1==null) {
			t1 = t2;
		}
		
		mergeTrees(t1.left, t2.left);
		mergeTrees(t1.right, t2.right);
		
		return t1;
    }
	
	public static void main(String[] args) {
		TreeNode newT = new mergeTrees().mergeTrees(new TreeNode(1), new TreeNode(2));
	}

}
