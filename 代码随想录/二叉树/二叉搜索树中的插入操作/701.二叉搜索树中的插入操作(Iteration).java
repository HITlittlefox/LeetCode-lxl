package 二叉搜索树中的插入操作;
/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
 */

// @lc code=start
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode parent = root;
        while (cur != null) {
            parent = cur;
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        TreeNode node = new TreeNode(val);
        if (val < parent.val) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return root;

    }
}
// @lc code=end
