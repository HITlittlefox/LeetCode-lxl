import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
    // public List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<Double> result = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        levelOrderIteration(root);
        return result;
    }

    // BFS--迭代方式--借助队列
    public void levelOrderIteration(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 先添加一个
        queue.add(node);

        while (!queue.isEmpty()) {
            // List<Integer> deepItemList = new ArrayList<Integer>();
            int len = queue.size();
            Double dividend = (double) 0;
            Double divisor = (double) len;
            // len=1
            while (len > 0) {
                TreeNode temp = queue.poll();
                dividend += temp.val;
                // deepItemList.add(temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                len--;
            }
            result.add(dividend / divisor);
            // resList.add(deepItemList);
        }
    }

}
// @lc code=end
