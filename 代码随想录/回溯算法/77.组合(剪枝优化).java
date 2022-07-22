import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    // 存放符合条件结果的集合
    List<List<Integer>> result = new ArrayList<>();
    // 用来存放符合条件结果
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    void backtracking(int n, int k, int startIndex) {
        // 终止条件
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            // result.add(path);
            return;
        }
        // 优化的地方 // 控制树的横向遍历开始的地方
        // 不再进行最终会少于k的遍历
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i); // 处理节点
            // 递归：控制树的纵向遍历，注意下一层搜索要从i+1开始
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1); // 回溯，撤销处理的节点
        }
    }
}
// @lc code=end
