package class06;

// 测试链接：https://leetcode.com/problems/maximum-depth-of-binary-tree
public class Code04_MaximumDepthOfBinaryTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	// 以root为头的树，最大高度是多少，返回！
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// 需要返回的高度，是左子树的高度与右子树高度的最大值，并加上根节点的1
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

}
