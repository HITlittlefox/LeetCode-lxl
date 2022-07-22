package 二叉搜索树中的搜索;
/*
 * @lc app=leetcode.cn id=700 lang=java
 *
 * [700] 二叉搜索树中的搜索
 */

// @lc code=start
// 迭代
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            } else if (root.val == val) {
                return root;
            }
        }
        return null;
    }
}
// @lc code=end
