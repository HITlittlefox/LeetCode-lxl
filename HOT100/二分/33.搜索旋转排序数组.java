package 二分;

/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    // 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
    // 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) { // 等号：考虑 left==right，即只有一个元素的情况
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
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
        return -1;
    }

}
// @lc code=end