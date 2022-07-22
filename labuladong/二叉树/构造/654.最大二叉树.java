package 构造;
/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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

/*
 * TreeNode constructMaximumBinaryTree([3,2,1,6,0,5]) {
 * // 找到数组中的最大值
 * TreeNode root = new TreeNode(6);
 * // 递归调用构造左右子树
 * root.left = constructMaximumBinaryTree([3,2,1]);
 * root.right = constructMaximumBinaryTree([0,5]);
 * return root;
 * }
 */

// 二分法 变种
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int low, int high) {
        // base case
        if (low > high) {
            return null;
        }
        // 面对每一个节点
        // 先找出最大值
        int indexOfMax = -1;
        int maxValue = Integer.MIN_VALUE;
        // for (int i = i; i < nums.length(); i++) {
        // for (int i = low; i < high; i++) {
        for (int i = low; i <= high; i++) {
            if (nums[i] > maxValue) {
                indexOfMax = i;
                maxValue = nums[i];
            }
        }

        // 构造根节点
        TreeNode root = new TreeNode(maxValue);

        // 递归左右子树
        root.left = build(nums, low, indexOfMax - 1);
        root.right = build(nums, indexOfMax + 1, high);

        return root;
    }
}

// @lc code=end
