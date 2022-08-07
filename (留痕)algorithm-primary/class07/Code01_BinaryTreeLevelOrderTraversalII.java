package class07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii
public class Code01_BinaryTreeLevelOrderTraversalII {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		// 选择LinkedList比选择ArrayList要好
		List<List<Integer>> ans = new LinkedList<>();
		if (root == null) {
			return ans;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> curAns = new LinkedList<>();
			// i<size不能是i<queue.size()，因为queue会变化，是动态的
			for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				curAns.add(curNode.val);
				if (curNode.left != null) {
					queue.add(curNode.left);
				}
				if (curNode.right != null) {
					queue.add(curNode.right);
				}
			}
			// System.out.println(ans.toString());
			// LinkedList的add (int index,E e)方法是在某个索引前插入元素E，
			// 先根据索引index找到相应元素，在该元素前添加新元素，
			ans.add(0, curAns);
		}
		return ans;
	}
	


}
