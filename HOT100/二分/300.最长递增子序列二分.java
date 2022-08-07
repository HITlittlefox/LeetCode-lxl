package 二分;

import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 用来保存最长上升子序列的列表arr
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            // 如果nums[i]比arr的最大值还大，可以组成一个更长的子序列
            // 并将其添加到arr末尾
            if (arr.size() == 0 || arr.get(arr.size() - 1) < nums[i]) {
                arr.add(nums[i]);
                continue;
            }
            // 如果nums[i]比arr最大值小，就要在arr中找查找一个合适的位置，
            // 将nums[i]放入，这查找过程是二分查找
            int begin = 0;
            int end = arr.size() - 1;
            while (begin <= end) {
                int mid = begin + (end - begin) / 2;
                if (arr.get(mid) > nums[i]) {
                    end = mid - 1;
                } else if (arr.get(mid) < nums[i]) {
                    begin = mid + 1;
                } else {
                    begin = mid;
                    break;
                }
            }
            arr.set(begin, nums[i]);
        }
        return arr.size();
    }
}
// @lc code=end
