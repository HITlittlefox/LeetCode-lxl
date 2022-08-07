import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    int[] memory;

    public int coinChange(int[] coins, int amount) {
        memory = new int[amount + 1];
        // 备忘录初始化为一个不会被取到的特殊值，代表还未被计算
        Arrays.fill(memory, Integer.MIN_VALUE);

        return dp(coins, amount);
    }

    int dp(int[] coins, int amount) {
        // base case
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
            
        // 查备忘录，防止重复计算
        if (memory[amount] != Integer.MIN_VALUE)
            return memory[amount];

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
        // 把计算结果存入备忘录
        memory[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memory[amount];
    }

}
// @lc code=end
