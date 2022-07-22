import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    void backtracking(int n, int k, int start) {
        // 终止条件
        if (path.size() == k) {
            // result.add(perRes);
            result.add(new ArrayList<>(path));
            return;
        }
        // for (int i = start; i < n; i++) {

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }

    }
}
// @lc code=end
