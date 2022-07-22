package 代码随想录.数组;

/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    // 从头到尾遍历
    // public int search(int[] nums, int target) {
    // for (int i = 0; i < nums.length; i++) {
    // if (nums[i] == target) {
    // return i;
    // }
    // }
    // return -1;
    // }
    // 二分法
    // 1. 左闭右闭
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } // 注意
            else if (nums[mid] > target) {
                right = mid - 1;
            } // 注意
        }
        return -1;
    }

    // 2. 左闭右开
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        return -1;
    }
}
// @lc code=end
