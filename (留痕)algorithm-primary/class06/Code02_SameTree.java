package class06;

// 测试链接：https://leetcode.com/problems/same-tree
public class Code02_SameTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		// 一个为空，一个不为空
		if (p == null ^ q == null) {
			return false;
		}
		// 都是空树 
		if (p == null && q == null) {
			return true;
		}
		// 都不为空
		// 头节点相同，左树相同，右数相同
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
