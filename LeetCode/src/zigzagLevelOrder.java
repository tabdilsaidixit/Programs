import java.util.*;
import java.util.Collections;
public class zigzagLevelOrder {
	 
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lis = new ArrayList<List<Integer>>();
        
        if(root == null){
            return lis;
        }
		GetLevelOrderElements(root, 0, lis);
        Integer[] nums = null;
		for(int i=1; i<lis.size(); i = i+2) {
			Collections.reverse(lis.get(i));
		}
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
