package 对称二叉树;
/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一棵树的子树
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        return preorder(root, subRoot);
    }

    private boolean preorder(TreeNode node, TreeNode subRoot) {
        if (node == null) {
            return false;
        }

        return isSameTreeRecursion(node, subRoot) || preorder(node.left, subRoot) || preorder(node.right, subRoot);
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
        return isSameTreeRecursion(p.left, q.left) && isSameTreeRecursion(p.right, q.right);
    }
}
// @lc code=end
