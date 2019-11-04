import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public int pathSum(TreeNode root, int sum) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        int height = getHeight(root,0, treeSet );
    	int[] arr=new int[height];
    
    	return pathSum(root, sum, arr, 0);
    }
    private int pathSum(TreeNode root, int sum, int[] arr, int height) {
    	int count = 0;
    	++height;
    	if(height<=0) {
    		return 0;
    	}
    	if(height>arr.length) {
    		return 0;
    	}
    	else {
    		arr[height-1] = root.val;
    	}
		for(int tempHeight = 0;tempHeight<height; tempHeight++ ) {
			int su =0;
			
			for(int k = tempHeight; k<height; k++) {
				su += arr[k];
			}
			if(su == sum) {
				count++;
			}
		}
		if(root.left!=null) {
			count+= pathSum(root.left, sum, arr, height);
		}
		if(root.right!=null) {
			count+= pathSum(root.right, sum, arr, height);
		}
		height--;
		return count;
	}
	private int getHeight(TreeNode root, int height, TreeSet<Integer> treeSet) {
    	if(root!=null) {
        	++height;
        	return Math.max(getHeight(root.right, height, treeSet), getHeight(root.left, height, treeSet));
    	}
    	return height;
		
	}
	public int pathSum(TreeNode root, int sum, List<ArrayList<TreeNode>> list ) {
    	int num =0;
    	if(root!=null) {
    		if(root.val == sum) {
    			num = num +1;
    		}
    		for(ArrayList<TreeNode> li:list) {
    			int su =0;
    			for(TreeNode l:li) {
    				if(l!=null) {
    					su+=l.val;
    				}
    			}
				su+=root.val;
    			if(su==sum) {
    				num++;
    			}
    		}
    		for(ArrayList<TreeNode> li:list) {
    			li.add(root);
    		}
    		ArrayList<TreeNode> arlis = new ArrayList<TreeNode>();
    		arlis.add(root);
    		
    		list.add(arlis);
    		num+=pathSum(root.left,sum,list)+pathSum(root.right,sum,list);
    	}
        return num;
    }
}

public class PathSum {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int sum = Integer.parseInt(line);
            
            int ret = new Solution1().pathSum(root, sum);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}