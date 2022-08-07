package 二分;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        return dfs(-1, 0, nums);
    }

    private int dfs(int pre, int cur, int[] nums) {
        if (cur == nums.length) {
            return 0;
        }
        int a = 0;
        int b = 0;
        // pre小于0是初始状态，继续往后判断
        // if条件满足说明是上升子序列，长度要+1
        if (pre < 0 || nums[pre] < nums[cur]) {
            a = dfs(cur, cur + 1, nums) + 1;
        }
        // 如果不满足可能是不满足上升子序列条件
        // 也可能是 满足条件但主动放弃
        b = dfs(pre, cur + 1, nums);
        return Math.max(a, b);
    }
}
// @lc code=end
