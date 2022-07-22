package 思路;
/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
// 这题能不能用「分解问题」的思维模式解决？
// 我们尝试给 invertTree 函数赋予一个定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
// 然后思考，对于某一个二叉树节点 x 执行 invertTree(x)，你能利用这个递归函数的定义做点啥？
// 先把 x 的左子树翻转:invertTree(x.left)
// 再把 x 的右子树翻转:invertTree(x.right)
// 最后把 x 的左右子树交换

// 这种「分解问题」的思路，核心在于你要给递归函数一个合适的定义，然后用函数的定义来解释你的代码；如果你的逻辑成功自恰，那么说明你这个算法是正确的。
class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 利用函数定义，先翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 然后交换左右子节点
        root.left = right;
        root.right = left;

        // 和定义逻辑自恰：以 root 为根的这棵二叉树已经被翻转，返回 root
        return root;
    }
}
// @lc code=end
