import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    // 存放符合条件结果的集合
    List<List<Integer>> result = new ArrayList<>();
    // 用来存放符合条件结果
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        // 包含的是1~9,所以这里的startIndex是1
        backtracking(n, k, 0, 1);
        return result;

    }

    void backtracking(int targetSum, int k, int sum, int startIndex) {
        // 终止条件
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            // 如果path.size() == k 但sum != targetSum 直接返回
            return;
        }
        // 控制树的横向遍历
        for (int i = startIndex; i <= 9; i++) {
            sum += i;
            path.add(i); // 处理节点
            backtracking(targetSum, k, sum, i + 1);
            // 回溯
            sum -= i;
            // 回溯，撤销处理的节点
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
