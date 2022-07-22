package 找树左下角的值;
/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
 */

import java.util.LinkedList;
import java.util.Queue;

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

    public int findBottomLeftValue(TreeNode root) {
        int res = findBottomLeftValueIteration(root);
        return res;
    }

    private int findBottomLeftValueIteration(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int res = node.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int len = queue.size();
            res = queue.peek().val;
            while (len > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                len--;
            }
        }
        return res;

    }

}
// @lc code=end
