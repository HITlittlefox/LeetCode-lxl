package 二分;

/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) { // 等号：考虑 left==right，即只有一个元素的情况
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            // 比33多
            if (nums[left] == nums[mid]) {
                left++; // 跳到下个left
                continue;
            }

            // [left,mid] 连续递增
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) { // 加等号，因为 left 可能是 target
                    right = mid - 1; // 在左侧 [left,mid) 查找
                } else {
                    left = mid + 1; // 在右侧 (mid,right] 查找
                }
            } else if (nums[left] > nums[mid]) { // [mid,right] 连续递增
                if (nums[mid] < target && target <= nums[right]) { // 加等号，因为 right 可能是 target
                    left = mid + 1;// 在右侧 (mid,right] 查找
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

}
// @lc code=end
