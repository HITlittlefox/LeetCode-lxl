package 翻转二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
/*
 * class Solution {
 * public TreeNode invertTree(TreeNode root) {
 * invertTreeRecursion(root);
 * return root;
 * }
 * 
 * void invertTreeRecursion(TreeNode root) {
 * if (root == null) {
 * return;
 * }
 * TreeNode temp = root.left;
 * root.left = root.right;
 * root.right = temp;
 * 
 * invertTreeRecursion(root.left);
 * invertTreeRecursion(root.right);
 * }
 * }
 */

/*
 * // DFS递归
 * class Solution {
 * 
 * // 前后序遍历都可以
 * // 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
 * 
 * public TreeNode invertTree(TreeNode root) {
 * if (root == null) {
 * return null;
 * }
 * 
 * swapChildren(root);
 * 
 * invertTree(root.left);
 * invertTree(root.right);
 * return root;
 * }
 * 
 * private void swapChildren(TreeNode root) {
 * TreeNode tmp = root.left;
 * root.left = root.right;
 * root.right = tmp;
 * }
 * }
 */

// 非递归
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // 终止条件
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        ArrayList<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            // 当前节点出栈
            TreeNode node = stack.pop();
            // 将当前节点的左右子树交换
            TreeNode tmp = node.right;
            node.right = node.left;
            node.left = tmp;
            // 右子树入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            // 左子树入栈
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return root;
    }
}
// @lc code=end
