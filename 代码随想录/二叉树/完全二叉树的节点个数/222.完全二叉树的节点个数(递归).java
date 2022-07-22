package 完全二叉树的节点个数;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
// 递归
class Solution {
    public int countNodes(TreeNode root) {
        int count = 0;
        return countNodeRecursion(root, count);
    }

    int countNodeRecursion(TreeNode node, int count) {
        if (node == null) {
            return 0;
        }
        int leftDepth = countNodeRecursion(node.left, count);
        int rightDepth = countNodeRecursion(node.right, count);

        return leftDepth + rightDepth + 1;

    }

}
// @lc code=end
