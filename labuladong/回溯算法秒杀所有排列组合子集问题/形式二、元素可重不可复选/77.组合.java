import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> path = new LinkedList<>();

    // 主函数
    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k);
        return res;
    }

    void backtracking(int start, int n, int k) {
        // base case
        if (k == path.size()) {
            // 遍历到了第 k 层，收集当前节点的值
            res.add(new LinkedList<>(path));
            return;
        }

        // 回溯算法标准框架
        for (int i = start; i <= n; i++) {
            // 选择
            path.addLast(i);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtracking(i + 1, n, k);
            // 撤销选择
            path.removeLast();
        }
    }

}
// @lc code=end
