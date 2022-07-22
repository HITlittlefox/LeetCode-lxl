package 二叉树的最近公共祖先;
/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        // 如果p,q为根节点，则公共祖先为根节点
        if (root.val == p.val || root.val == q.val)
            return root;
        // 如果p,q在左子树，则公共祖先在左子树查找
        if (find(root.left, p) && find(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 如果p,q在右子树，则公共祖先在右子树查找
        if (find(root.right, p) && find(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 如果p,q分属两侧，则公共祖先为根节点
        return root;
    }

    private boolean find(TreeNode root, TreeNode c) {
        if (root == null)
            return false;
        if (root.val == c.val) {
            return true;
        }

        return find(root.left, c) || find(root.right, c);
    }
}
// @lc code=end
