package 完全二叉树的节点个数;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// 迭代:层序遍历
class Solution {
    public int countNodes(TreeNode root) {
        return countNodeIteration(root);
    }

    int countNodeIteration(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode temp = queue.poll();
                result++;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                len--;
            }
        }
        return result;

    }
}
// @lc code=end
