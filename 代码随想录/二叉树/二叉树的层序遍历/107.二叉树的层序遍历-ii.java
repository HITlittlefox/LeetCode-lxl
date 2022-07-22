import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
    public List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrderBottomIteration(root);
        if (result == null) {
            return result;
        }

        int right = result.size() - 1;
        int left = 0;
        while (left < right) {
            List<Integer> temp1 = new ArrayList<>();
            List<Integer> temp2 = new ArrayList<>();
            temp1 = result.get(left);
            temp2 = result.get(right);
            result.remove(left);
            result.add(left, temp2);
            result.remove(right);
            result.add(right, temp1);
            left++;
            right--;
        }

        return result;

    }

    void levelOrderBottomIteration(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 先添加一个
        queue.add(node);

        while (!queue.isEmpty()) {
            List<Integer> deepItemList = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode temp = queue.poll();
                deepItemList.add(temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
                len--;
            }
            result.add(deepItemList);
        }
        return;
    }
}
// @lc code=end
