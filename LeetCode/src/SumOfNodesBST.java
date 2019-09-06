
public class SumOfNodesBST {
public int rangeSumBST(TreeNode root, int L, int R) {

	TreeNode temp = root;
	while(temp!=null)
	{
		int tempValue = temp.val;
		if(!(tempValue>=L && tempValue<=R) )
		{
			tempValue = 0;
		}
		int tempRightValue = rangeSumBST(temp.left, L, R);
		int tempLeftValue = rangeSumBST(temp.left, L, R);
		return tempValue+ tempRightValue + tempLeftValue;
	}
	
	return 0;
    }

public static void main(String[] args) {
	
}
	
}
