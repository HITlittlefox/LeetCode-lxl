/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        // 1. 为什么 while 循环的条件中是 <=，而不是 <？
        // 因为初始化 right 的赋值是 nums.length - 1，即最后一个元素的索引，而不是 nums.length。
        // 相当于两端都闭区间 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        // 为什么 left = mid + 1，right = mid - 1？我看有的代码是 right = mid
        // 或者left=mid，没有这些加加减减，到底怎么回事，怎么判断？

        // 本算法的搜索区间是两端都闭的，即 [left, right]。那么当我们发现索引 mid 不是要找的 target 时，下一步应该去搜索哪里呢？当然是去搜索区间 [left, mid-1] 或者区间 [mid+1, right] 对不对？因为 mid 已经搜索过，应该从搜索区间中去除。

        // while 循环什么时候应该终止？
        // 搜索区间为空的时候应该终止
        return -1;
    }

}
// @lc code=end
