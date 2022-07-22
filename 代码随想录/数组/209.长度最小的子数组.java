package 代码随想录.数组;

import javax.swing.text.TabExpander;

/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
// 思路1:找出所有的和为target的数组,并比较他们的长度,返回最小
// 思路2:前缀和?
/*
// 暴力解法
// 以每个点出发,找之后加和>=target的可能性
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // 子序列的数值之和
        int sum = 0;
        // 子序列的长度
        int subLength = Integer.MAX_VALUE;
        // 设置子序列起点为i
        for (int i = 0; i < n; i++) {
            sum = 0;
            // 设置子序列终止位置为j
            for (int j = i; j < n; j++) {
                sum += nums[j];
                // 一旦发现子序列和超过了s，更新result
                if (sum >= target) {
                    // 取子序列的长度
                    subLength = Math.min(subLength, j - i + 1);
                    // 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                    break;
                }
            }
        }
        return subLength == Integer.MAX_VALUE ? 0 : subLength;
    }
}
*/

// 使用队列相加（实际上我们也可以把它称作是滑动窗口，这里的队列其实就相当于一个窗口）
// 原生滑动窗口
// 
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int innerCur = 0;
        int length = 0;
        // 这里的指针是指的终止位置
        for (int lastCur = 0; lastCur < nums.length; lastCur++) {
            // 当窗口内加和>=target,让初始指针往前移,从初始位置不断缩小窗口,以逼近更小的满足条件的数组
            sum += nums[lastCur];
            while (sum >= target) {
                length = lastCur - innerCur + 1;
                sum -= nums[innerCur];
                result = Math.min(length, result);
                innerCur++;
            }
        }
        return result = result == Integer.MAX_VALUE ? 0 : result;
    }
}

// @lc code=end
