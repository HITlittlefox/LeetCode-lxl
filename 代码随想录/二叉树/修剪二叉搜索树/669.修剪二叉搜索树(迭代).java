package 修剪二叉搜索树;
/*
 * @lc app=leetcode.cn id=669 lang=java
 *
 * [669] 修剪二叉搜索树
 */

// @lc code=start
class Solution {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // 处理头结点，让root移动到[L, R] 范围内，注意是左闭右闭
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        TreeNode cur = root;
        // 此时root已经在[L, R] 范围内，处理左孩子元素小于L的情况
        while (cur != null) {
            while (cur.left != null && cur.left.val < low) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }
        cur = root;
        // 此时root已经在[L, R] 范围内，处理右孩子大于R的情况
        while (cur != null) {
            while (cur.right != null && cur.right.val > high) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }
        return root;
    }
}

// @lc code=end
