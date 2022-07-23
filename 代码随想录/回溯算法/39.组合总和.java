import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = 0;
        // 递归函数参数
        backtracking(candidates, target, sum, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex) {
        // 递归终止条件
        if (sum > target) {
            return;
        }
        if (sum == target) {
            // result.add(path);
            result.add(new ArrayList<>(path));

            return;
        }

        // 单层搜索的逻辑
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum, i); // 关键点:不用i+1了，表示可以重复读取当前的数
            sum -= candidates[i]; // 回溯
            path.remove(path.size() - 1); // 回溯
        }
    }
}
// @lc code=end
