
public class InsertBinaryTree {
public TreeNode insertIntoBST(TreeNode root, int val) {
        
	
	TreeNode ins = new TreeNode(val);
	
	if(val> root.val)
	{
		if(root.right!=null)
		{
			insertIntoBST(root.right, val);			
		}
		else
		{
			root.right = ins;
			return root;
		}
	}
	else
	{
		if(root.left!=null)
		{
			insertIntoBST(root.left, val);			
		}
		else
		{
			root.left = ins;
			return root;
		}
	}
	
	return root;
	
    }

public static void main(String[] args) {
	
	
}

}
