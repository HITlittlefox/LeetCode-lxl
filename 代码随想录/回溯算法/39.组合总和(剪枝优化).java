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
        backtracking(candidates, target, sum, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex) {
        // 如果 sum + candidates[i] > target 就终止遍历
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));

            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            // 关键点:不用i+1了，表示可以重复读取当前的数
            backtracking(candidates, target, sum, i);
            sum -= candidates[i]; // 回溯
            path.remove(path.size() - 1); // 回溯
        }
    }
}
// @lc code=end
