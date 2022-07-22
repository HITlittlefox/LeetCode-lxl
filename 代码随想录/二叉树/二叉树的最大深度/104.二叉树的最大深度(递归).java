package 二叉树的最大深度;
/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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

// 递归法
class Solution {
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root);
    }

    int getMaxDepth(TreeNode node) {
        if (node == null)
            return 0;
        // 左
        int leftDepth = getMaxDepth(node.left);
        // 右
        int rightDepth = getMaxDepth(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
// @lc code=end
