import java.util.*;
public class levelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.last();
        List<List<Integer>> lis = new ArrayList<List<Integer>>();
        if(root == null){
            return lis;
        }
		GetLevelOrderElements(root, 0, lis);
		return lis;
    }

	private void GetLevelOrderElements(TreeNode root, int currentHeight, List<List<Integer>> lis ) {
		++currentHeight;
		if(lis.size()<currentHeight) {
			lis.add(new ArrayList<Integer>());
		}
		lis.get(currentHeight-1).add(root.val);
		
		if(root.left!=null) {
			GetLevelOrderElements(root.left, currentHeight, lis);
		}
        
        
		if(root.right!=null) {
			GetLevelOrderElements(root.right, currentHeight, lis);
		}
	}
}
