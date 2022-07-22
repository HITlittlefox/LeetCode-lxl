package 二叉搜索树的最近公共祖先;
/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // 左树找到p和q,就去左树找最近公共祖先
        if (find(root.left, p) && find(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 右树找到p和q,就去右树找最近公共祖先
        if (find(root.right, p) && find(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 如果p和q不处在同一侧
        return root;

    }

    private boolean find(TreeNode root, TreeNode c) {
        if (root == null) {
            return false;
        }
        if (root.val == c.val) {
            return true;
        }
        return (find(root.left, c)) || (find(root.right, c));
    }

}
// @lc code=end
