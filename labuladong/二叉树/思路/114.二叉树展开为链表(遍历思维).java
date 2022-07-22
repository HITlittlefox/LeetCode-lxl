package 思路;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
class Solution {
    // 虚拟头节点，dummy.right 就是结果
    TreeNode dummy = new TreeNode(-1);
    // 用来构建链表的指针
    TreeNode cur = dummy;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        cur.right = new TreeNode(root.val);
        cur = cur.right;

        flatten(root.left);
        flatten(root.right);
    }
}
// @lc code=end
