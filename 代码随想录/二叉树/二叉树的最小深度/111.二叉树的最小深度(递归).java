package 二叉树的最小深度;
/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
class Solution {
    public int minDepth(TreeNode root) {
        return minDepthRecursion(root);
    }

    int minDepthRecursion(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int leftDepth = minDepthRecursion(node.left);
        int rightDepth = minDepthRecursion(node.right);

        if (node.left == null) {
            return rightDepth + 1;
        }
        if (node.right == null) {
            return leftDepth + 1;
        }
        // 左右结点都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
// @lc code=end
