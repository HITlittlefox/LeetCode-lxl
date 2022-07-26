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

    void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 优化的地方
        // 控制树的横向遍历开始的地方
        // 不再进行最终会少于k的遍历
        // 也就是说剩下的位置需要能让
        // 来举一个例子，n = 4，k = 4 的话，那么第一层 for 循环的时候，从元素 2 开始的遍历都没有意义了。
        // 在第二层for循环，从元素3开始的遍历都没有意义了。图中每一个节点（图中为矩形），就代表本层的一个for循环，那么每一层的for循环从第二个数开始遍历的话，都没有意义，都是无效遍历。所以，可以剪枝的地方就在递归中每一层的for循环所选择的起始位置。
        // 如果 for 循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。
        // i:for 循环里选择的起始位置
        // path.size()已经选择的元素个数
        // k - path.size()还需要的元素个数
        // n - (k - path.size ()) + 1 : 在集合 n 中至多要从该起始位置 :，开始遍历
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
