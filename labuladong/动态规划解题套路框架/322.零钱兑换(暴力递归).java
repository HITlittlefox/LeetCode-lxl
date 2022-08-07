/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start

// 递归解法

// 状态：目标总金额 amount
// 选择：coins数组中列出的不同面额的硬币
// 函数的定义：凑成总金额amount所需的最少的硬币个数coinChange(coins, amount)
// base case: 金额 = 0，返回 0；金额 < 0, 不可能凑出，返回 -1

// 状态转移方程:
//    coinChange(coins, amount) = 1 + min(coinChange(coins, amount-coins[1]), coinChange(coins, amount-coins[2]), coinChange(coins, amount-coins[3])...  ) 

// coinChange([1, 2, 5], 11) =  
// 1 + min(coinChange([1, 2, 5], 10), coinChange([1, 2, 5], 9), coinChange([1, 2, 5], 6)) 
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 题目要求的最终结果是 dp(coins, amount)
        return dp(coins, amount);
    }

    // 定义：要凑出金额 amount，至少要 dp(coins, amount) 个硬币
    int dp(int[] coins, int amount) {
        // base case
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1)
                continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
// @lc code=end
