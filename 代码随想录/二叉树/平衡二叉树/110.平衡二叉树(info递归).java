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
        // 获得根节点两个信息中的isBalanced
        return process(root).isBalanced;
    }

    class Info {
        // 该节点作为根节点的树是否平衡
        public boolean isBalanced;
        // 该节点的高度
        public int height;

        // 常规构造函数
        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    Info process(TreeNode root) {
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
// @lc code=end
