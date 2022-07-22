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
// 最大深度就是根节点到「最远」叶子节点的最长路径上的节点数
// 遍历一遍二叉树，用一个外部变量记录每个节点所在的深度，取最大值就可以得到最大深度，这就是遍历二叉树计算答案的思路。
class Solution {
    // 最大深度
    int res = 0;
    // 当前节点的深度
    int depth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        // 前序位置是进入一个节点的时候，
        depth++;
        if (root.left == null && root.right == null) {
            // 每次到达叶子节点,都更新最大深度
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        // 后序位置是离开一个节点的时候,清理现场
        depth--;
    }
}
// @lc code=end
