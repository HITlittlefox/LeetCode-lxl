package 二叉树的最小深度;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        int result = connectIteration(root);
        return result;
    }

    int connectIteration(TreeNode root) {
        int result = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            result++;
            while (len > 0) {
                TreeNode temp = queue.poll();
                // System.out.println(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (temp.left == null && temp.right == null) {
                    return result;
                }
                len--;

            }

        }
        return result;
    }
}
// @lc code=end
