package 纲领;

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
// 容易发现一棵二叉树的最大深度可以通过子树的最大深度推导出来，这就是分解问题计算答案的思路。
class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        int res = Math.max(leftMax, rightMax) + 1;

        return res;
    }
}
// @lc code=end
