package 二叉搜索树的最近公共祖先;
/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root, p, q);
    }

    private TreeNode traversal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > q.val && root.val > p.val) {
            TreeNode left = traversal(root.left, p, q);
            if (left != null) {
                return left;
            }
        }
        if (root.val < q.val && root.val < p.val) {
            TreeNode right = traversal(root.right, p, q);
            if (right != null) {
                return right;
            }
        }
        return root;
    }
}
// @lc code=end
