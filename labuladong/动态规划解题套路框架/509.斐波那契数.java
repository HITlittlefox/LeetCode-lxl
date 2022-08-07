/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        // 备忘录全初始化为 0
        int[] memory = new int[N + 1];
        System.out.println("memoryLength:" + memory.length);
        // 进行带备忘录的递归
        return helper(memory, N);
    }

    int helper(int[] memory, int n) {
        // base case
        if (n == 0 || n == 1)
            return n;
        // 已经计算过，不用再计算了
        if (memory[n] != 0)
            return memory[n];
        // 状态转移方程
        memory[n] = helper(memory, n - 1) + helper(memory, n - 2);
        return memory[n];
    }
}
// @lc code=end
