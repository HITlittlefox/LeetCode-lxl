package 平衡二叉树;

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

// 递归
// 对于当前遍历到的节点，
// 首先计算左右子树的高度，
// 如果左右子树的高度差不超过 1，
// 再分别递归地遍历左右子节点，并判断左子树和右子树是否平衡。
// 这是一个自顶向下的递归的过程。
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            // 高度差的绝对值小于等于1,并且左子树是平衡树,并且右子树是平衡树
            return Math.abs(getHeightRecrusion(root.left) - getHeightRecrusion(root.right)) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int getHeightRecrusion(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(getHeightRecrusion(node.left), getHeightRecrusion(node.right)) + 1;
    }
}
// @lc code=end
