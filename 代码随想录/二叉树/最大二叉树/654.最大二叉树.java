package 最大二叉树;
/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 */

// @lc code=start
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // // 左闭右开
        // return constructMaximumBinaryTreeRecursion(nums, 0, nums.length);
        // 左闭右闭
        return constructMaximumBinaryTreeRecursion(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTreeRecursion(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 左闭右开
        // if (right - left < 1) {// 没有元素了
        // return null;
        // }
        // if (right - left == 1) {// 只有一个元素
        // return new TreeNode(nums[left]);
        // }
        // int tempMaxIndex = left;
        // int tempMax = nums[tempMaxIndex];

        // for (int i = left + 1; i < right; i++) {
        // if (nums[i] > tempMax) {
        // tempMax = nums[i];
        // tempMaxIndex = i;
        // }
        // }

        // 找到数组中的最大值和对应的索引
        int tempMaxIndex = -1, tempMax = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (tempMax < nums[i]) {
                tempMaxIndex = i;
                tempMax = nums[i];
            }
        }
        TreeNode root = new TreeNode(tempMax);
        root.left = constructMaximumBinaryTreeRecursion(nums, left, tempMaxIndex - 1);
        root.right = constructMaximumBinaryTreeRecursion(nums, tempMaxIndex + 1, right);
        return root;
    }
}
// @lc code=end
