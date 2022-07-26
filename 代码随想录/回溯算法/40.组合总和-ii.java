import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        // 如果target小于最小值,那么数组中全部的值都比target大,无法通过加和获得target
        if (target < candidates[0]) {
            return result;
        }

        backtracking(candidates, target, 0);

        return result;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length &&
                candidates[i] + sum <= target; i++) {
            // 正确剔除重复解的办法
            // 跳过同一树层使用过的元素
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            sum = sum + candidates[i];
            path.add(candidates[i]);
            System.out.println(sum);
            backtracking(candidates, target, i + 1);

            sum -= path.get(path.size() - 1);
            path.remove(path.size() - 1);

        }
    }
}
// @lc code=end
