package 二叉搜索树中的搜索;
/*
 * @lc app=leetcode.cn id=700 lang=java
 *
 * [700] 二叉搜索树中的搜索
 */

// @lc code=start
// 递归
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // if (root == null) {
        // return null;
        // }
        // if (root.val == val) {
        // return root;
        // }
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return null;
    }
}
// @lc code=end
