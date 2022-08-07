/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        double result = 0;
        // 分别进行奇数偶数处理
        if (length % 2 != 0) {
            result = getNum(nums1, nums2, length / 2);
        } else {
            result = getNum(nums1, nums2, length / 2 - 1) / 2 + getNum(nums1, nums2, length / 2) / 2;
        }
        return result;
    }

    public double getNum(int[] nums1, int[] nums2, int k) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int cur = 0;
        while (i < nums1.length && j < nums2.length && cur <= k) {
            if (nums1[i] < nums2[j])
                result[cur++] = nums1[i++];
            else
                result[cur++] = nums2[j++];
        }
        while (i < nums1.length && cur <= k)
            result[cur++] = nums1[i++];
        while (j < nums2.length && cur <= k)
            result[cur++] = nums2[j++];
        return result[cur - 1];
    }
}
// @lc code=end
