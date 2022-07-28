import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start
class Solution {
    // path记录路线，res存所有路线
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    // used数组用于标记同一树枝不能重复使用！即不能重复使用一张票
    boolean[] used;
    boolean find;

    public List<String> findItinerary(List<List<String>> tickets) {
        used = new boolean[tickets.size()];

        // 先按字典序从小到大排列降落地
        tickets.sort((o1, o2) -> o1.get(1).compareTo(o2.get(1)));
        path.add("JFK");
        backTracking(tickets, "JFK");
        return res.get(0);
    }

    void backTracking(List<List<String>> tickets, String outset) {
        // 算个小剪枝吧，找到一条就行
        if (find) {
            return;
        }
        // 因为这些航班肯定会有一条路线是正确的
        // 所以我们加入path的size如果等于tickets.size()+1说明我们找到路线了
        if (path.size() == tickets.size() + 1) {
            find = true;
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < tickets.size(); i++) {
            // 如果出发地和上一个的降落地相同 并且 同一条路线中没有重复使用一张票
            if (tickets.get(i).get(0).equals(outset) && !used[i]) {
                // 标记该票已经使用过
                used[i] = true;
                path.add(tickets.get(i).get(1));
                // 把现在的降落地加入递归函数
                backTracking(tickets, tickets.get(i).get(1));
                // 回溯！ 该票标记为未使用 路线中移除该票
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
// @lc code=end
