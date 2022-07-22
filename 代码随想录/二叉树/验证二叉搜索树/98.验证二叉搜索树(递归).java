package 验证二叉搜索树;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidInfoRecursion(root, null, null);

    }

    boolean isValidInfoRecursion(TreeNode root, TreeNode minValue, TreeNode maxValue) {
        if (root == null) {
            return true;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (minValue != null && root.val <= minValue.val)
            return false;
        if (maxValue != null && root.val >= maxValue.val)
            return false;
        return isValidInfoRecursion(root.left, minValue, root)
                && isValidInfoRecursion(root.right, root, maxValue);
    }
}
// @lc code=end
