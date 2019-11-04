import java.util.*;

public class isSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		Queue<TreeNode> queueP = new LinkedList<TreeNode>();
		Queue<TreeNode> queueQ = new LinkedList<TreeNode>();
		Stack<TreeNode> stackP = new Stack<TreeNode>();
		Stack<TreeNode> stackQ = new Stack<TreeNode>();
		stackP.push(p);
		stackQ.push(q);

		while (!stackP.isEmpty()) {
			TreeNode poped = stackP.pop();
			queueP.add(poped);
			if (poped != null) {
				stackP.add(poped.left);
				stackP.add(poped.right);
			}
		}

		while (!stackQ.isEmpty()) {
			TreeNode poped = stackQ.pop();
			queueQ.add(poped);
			if (poped != null) {
				stackQ.add(poped.left);
				stackQ.add(poped.right);
			}
		}

		if (queueP.size() != queueQ.size()) {
			return false;
		} else {
			while (queueP.size() > 0) {
				TreeNode popedP = queueP.poll();
				TreeNode popedQ = queueQ.poll();
				if (popedP == null && popedQ == null) {
					continue;
				}
				if (p == null || q == null) {
					return false;
				}
				if (p.val != q.val) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isSameTree1(TreeNode p, TreeNode q) {

		boolean isSame = true;

		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		} else {
			isSame = isSame & isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
		}

		return isSame;
	}
}
