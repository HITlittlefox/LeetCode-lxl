package class07;

// 测试链接：https://leetcode.com/problems/balanced-binary-tree
public class Code02_BalancedBinaryTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// 以某个节点为头的时候
	// 1. 整棵树是否平衡
	// 2. 整棵树的高度是什么
	public static class Info {
		public boolean isBalanced;
		public int height;

		public Info(boolean i, int h) {
			isBalanced = i;
			height = h;
		}
	}

	public static boolean isBalanced(TreeNode root) {
		// 获得根节点两个信息中的isBalanced
		return process(root).isBalanced;
	}

	public static Info process(TreeNode root) {
		if (root == null) {
			return new Info(true, 0);
		}
		// x!=null
		// 获得左树两个信息
		Info leftInfo = process(root.left);
		// 获得右树两个信息
		Info rightInfo = process(root.right);
		// 获得整棵树的高度：左高与右高的最大值，再+1
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
				&& Math.abs(leftInfo.height - rightInfo.height) < 2;
		// 把根节点的两个信息返回
		return new Info(isBalanced, height);
	}

}
