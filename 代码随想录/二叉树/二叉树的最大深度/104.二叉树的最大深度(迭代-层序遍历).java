package 二叉树的最大深度;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        int result = connectIteration(root);
        return result;
    }

    int connectIteration(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }
        // 创建队列,每一次要弹出时,队列中都保存的是一层的内容
        Queue<TreeNode> queue = new LinkedList<>();
        // 先放第一个
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            while (len > 0) {
                TreeNode temp = queue.poll();
                // System.out.println(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                len--;

            }

        }
        return depth;
    }
}
// @lc code=end
