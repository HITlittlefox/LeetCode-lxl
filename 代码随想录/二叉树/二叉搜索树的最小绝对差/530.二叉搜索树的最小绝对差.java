package 二叉搜索树的最小绝对差;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int mixDiff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int tempDiff = list.get(j) - list.get(i);
                mixDiff = tempDiff < mixDiff ? tempDiff : mixDiff;
            }
        }
        return mixDiff;

    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
// @lc code=end
