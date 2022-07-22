import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    public List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        largestValuesIteration(root);
        return result;
    }

    void largestValuesIteration(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            // List<Integer> deepItemList = new ArrayList<>();
            int tempMax = Integer.MIN_VALUE;
            int len = queue.size();
            while (len > 0) {
                TreeNode tempNode = queue.poll();
                tempMax = tempNode.val > tempMax ? tempNode.val : tempMax;

                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                len--;
            }
            result.add(tempMax);
        }
    }
}
// @lc code=end
