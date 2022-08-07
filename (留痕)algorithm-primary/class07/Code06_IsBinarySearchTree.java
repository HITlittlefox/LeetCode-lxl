package class07;

public class Code06_IsBinarySearchTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// 递归函数同等全：都拿到三个信息
	public static class Info {
		public boolean isBST;
		public int max;
		public int min;

		public Info(boolean is, int max, int min) {
			isBST = is;
			this.max = max;
			this.min = min;
		}
	}

	public static boolean IsBinarySearchTree(TreeNode root) {
		return process(root).isBST;
	}

	public static Info process(TreeNode root) {
		// root == null
		if (root == null) {
			// 可以返回0吗？不行，假如root的值是负数呢？想一下可以吗？
			return null;
		}
		// root != null
		Info leftInfo = process(root.left);
		Info rightInfo = process(root.right);

		// 假如上边有返回null的，这个地方就有压力了，你得解决null的情况呀！
		int max = root.val;
		int min = root.val;
		if (leftInfo != null) {
			max = Math.max(leftInfo.max, max);
			min = Math.max(leftInfo.min, min);
		}
		if (rightInfo != null) {
			max = Math.max(rightInfo.max, max);
			min = Math.max(rightInfo.min, min);
		}
		// 首先我们默认为true；然后我们把所有违规的都列全，赋值为false，最后统一返回就可以。
		// 这些情况有哪些呢？
		// 1. 左树或右树有值的情况：看左树和右树是否满足搜索树的条件、看值是否符合条件。
		// 2. 左树和右树都是null，直接返回true。
		boolean isBST = true;
		if (leftInfo != null && !leftInfo.isBST) {
			isBST = false;
		}
		if (rightInfo != null && !leftInfo.isBST) {
			isBST = false;
		}
		// 判读左树的最大值是否小于root的值。
		boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < root.val);
		// 判读右树的最小值是否大于root的值。
		boolean rightMinMoreX = leftInfo == null ? true : (rightInfo.min > root.val);

		if (!leftMaxLessX || !rightMinMoreX) {
			isBST = false;
		}

		return new Info(isBST, max, min);
	}

}