/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    public int maxPathSum(TreeNode root) {
        return process(root).maxDistance;
    }

    // 信息，以node为根节点的树的最大距离和整棵树的高度
    class Info {
        public int maxDistance;
        public int height;

        public Info(int dis, int h) {
            maxDistance = dis;
            height = h;
        }
    }

    Info process(TreeNode node) {
        // base case
        if (node == null) {
            return new Info(0, 0);
        }
        // 递归左孩子
        // 递归右孩子
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        // 后序：因为需要拿到信息后进行操作，所以用后序
        // 我的高度
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 左树最大距离
        int p1 = leftInfo.maxDistance;
        // 右树最大距离
        int p2 = rightInfo.maxDistance;
        // 左树高度+右树高度+1
        int p3 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(Math.max(p1, p2), p3);
        return new Info(maxDistance, height);
    }
}
// @lc code=end
