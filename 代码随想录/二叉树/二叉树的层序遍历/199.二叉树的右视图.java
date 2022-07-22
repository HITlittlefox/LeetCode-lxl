import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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

    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewIteration(root);

        return result;
    }

    void rightSideViewIteration(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int deepLastItemList = 0;
            int len = queue.size();

            while (len > 0) {
                TreeNode temp = queue.poll();
                if (len == 1) {
                    deepLastItemList = temp.val;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                len--;

            }
            result.add(deepLastItemList);

        }

    }

}
// @lc code=end
