/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    // 左右要求一样，Info信息返回的结构体
    class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    Info process(TreeNode node) {
        if (node == null) {
            return new Info(true, 0);
        }

        // 对左右节点进行操作
        // 假设左树可以给信息
        Info leftInfo = process(node.left);

        // 假设右树可以给信息
        Info rightInfo = process(node.right);

        // 整棵树的高度
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        // 对单个节点进行操作(需要拿到信息后,所以对本节点的操作出现在后序)
        // 该树是否平衡，先假设true，再用条件进行判断
        boolean isBalanced = true;
        if (!leftInfo.isBalanced || !rightInfo.isBalanced) {
            isBalanced = false;
        }
        if (Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }
        return new Info(isBalanced, height);
    }
}
// @lc code=end
