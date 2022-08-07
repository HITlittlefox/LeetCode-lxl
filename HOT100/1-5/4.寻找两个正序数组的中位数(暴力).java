import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            nums[nums1.length + j] = nums2[j];
        }
        Arrays.sort(nums);
        System.out.println(nums.length);
        int start = 0;
        int end = nums.length;
        int mid = (start + end) / 2;
        if (nums.length % 2 == 1) {
            return (double) nums[mid];
        } else {
            return ((double) (nums[mid-1] + nums[mid])) / 2;
        }

    }
}
// @lc code=end
