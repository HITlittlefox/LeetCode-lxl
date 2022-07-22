package 修剪二叉搜索树;
/*
 * @lc app=leetcode.cn id=669 lang=java
 *
 * [669] 修剪二叉搜索树
 */

// @lc code=start
class Solution {
    // 定义：删除 BST 中小于 low 和大于 high 的所有节点，返回结果 BST
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        // 返回右边
        if (root.val < low) {
            // 直接返回 root.right
            // 等于删除 root 以及 root 的左子树
            return trimBST(root.right, low, high);
        }
        // 返回左边
        if (root.val > high) {
            // 直接返回 root.left
            // 等于删除 root 以及 root 的右子树
            return trimBST(root.left, low, high);
        }

        // 闭区间 [lo, hi] 内的节点什么都不做

        // root->left接入符合条件的左孩子
        root.left = trimBST(root.left, low, high);
        // root->right接入符合条件的右孩子
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
// @lc code=end
