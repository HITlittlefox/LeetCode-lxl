package 将有序数组转换为二叉搜索树;
/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 */

// @lc code=start
class Solution {
    // 左闭右闭
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    // 左闭右闭区间[left, right]
    TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 防止数值越界
        int mid = left + ((right - left) >> 2);

        TreeNode root = new TreeNode(nums[mid]);

        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);
        return root;

    }
}
// @lc code=end
