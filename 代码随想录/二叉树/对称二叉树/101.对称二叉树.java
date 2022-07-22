package 对称二叉树;
/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    // 针对一个根节点,比较他左右两边是否相同,四种情况
    // 1. left空
    // 2. right空
    // 3. 都空
    // 4. 都不空 4.1且不等 4.2且相等
    boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null && left.val != right.val) {
            return false;
        }

        // 左往左走,右往右走
        boolean compareOutside = compare(left.left, right.right);
        // 左找右子孩子,右找左子孩子
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;

    }
}
// @lc code=end
