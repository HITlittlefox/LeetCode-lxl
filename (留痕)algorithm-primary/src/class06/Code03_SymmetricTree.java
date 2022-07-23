package class06;

// 测试链接：https://leetcode.com/problems/symmetric-tree
public class Code03_SymmetricTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	public static boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	public static boolean isMirror(TreeNode h1, TreeNode h2) {
		// 头节点不会破坏镜面关系
		if (h1 == null ^ h2 == null) {
			return false;
		}
		// 头节点如果是空，自己和自己镜面没问题
		if (h1 == null && h2 == null) {
			return true;
		}
		return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);
	}

}
