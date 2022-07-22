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
// 在心中默念二叉树解题总纲：
// 1、这题能不能用「遍历」的思维模式解决？
// 可以，我写一个 traverse 函数遍历每个节点，让每个节点的左右子节点颠倒过来就行了。
// 单独抽出一个节点，需要让它做什么？让它把自己的左右子节点交换一下。
// 需要在什么时候做？好像前中后序位置都可以。
// 只要把二叉树上的每一个节点的左右子节点进行交换，最后的结果就是完全翻转之后的二叉树。
class Solution {

    public TreeNode invertTree(TreeNode root) {
        // 遍历二叉树,交换每个节点的子节点
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        // 每个节点做的就是交换它的左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 遍历框架,去遍历左右子树的节点
        traverse(root.left);
        traverse(root.right);
    }
}
// @lc code=end
