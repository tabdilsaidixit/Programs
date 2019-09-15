import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class Solution {
    public int findBottomLeftValue(TreeNode root) {
    	
    	if(root==null) {
    		return 0;
    	}
    	List<Integer> arrayList = new ArrayList<Integer>();
    	int height = findHeight(root); 
    	findElementsAtGivenHeight(root,0, arrayList, height);
		return arrayList.get(0);
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
    
    public int findElementsAtGivenHeight(TreeNode root, int height, List<Integer> arrayList, int targetHeight ) {
    	++height;
    	int currentHeight  = 1; 
    	int leftHeight = 0, rightHeight = 0;  
    	if(root.left!=null) {
    		leftHeight=findElementsAtGivenHeight(root.left, height, arrayList, targetHeight);
    	}
    	if(root.right!=null) {
        	rightHeight=findElementsAtGivenHeight(root.right, height, arrayList, targetHeight);    		
    	}
    	if(leftHeight>rightHeight) {
    		currentHeight+=leftHeight;
    	}
    	else {
    		currentHeight+=rightHeight;
    	}
    	if(height == targetHeight) {
    		arrayList.add(root.val);
    	}
		return currentHeight ;
        
    }
}

public class MainClass {
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
       
        String line = "[1,2,3,4,null,5,6,null,null, 7]";
        if (line != null) {
            TreeNode root = stringToTreeNode(line);
            
            int ret = new Solution().findBottomLeftValue(root);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}