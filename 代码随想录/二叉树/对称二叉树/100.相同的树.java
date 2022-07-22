/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeRecursion(p, q);
    }

    private boolean isSameTreeRecursion(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p != null && q != null && p.val != q.val) {
            return false;
        }
        // p,q均不为空
        boolean isSameTreeLeft = isSameTreeRecursion(p.left, q.left);
        boolean isSameTreeRight = isSameTreeRecursion(p.right, q.right);
        return isSameTreeLeft && isSameTreeRight;
    }
}
// @lc code=end
