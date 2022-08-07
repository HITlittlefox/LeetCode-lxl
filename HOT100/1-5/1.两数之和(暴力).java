/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
/* 
 * 1. 因为需要记录下标,不能先sort
 * 2. 嵌套for循环
 */
class Solution {
    int[] res = new int[2];

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] - nums[j] == 0) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
// @lc code=end
