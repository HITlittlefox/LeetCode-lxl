import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    void backtracking(int[] nums, int startIndex) {
        // 横向遍历
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 非增量序列
            if (path.size() > 0 && nums[i] < path.get(path.size() - 1)
                    || hashSet.contains(nums[i])) {
                continue;
            }
            hashSet.add(nums[i]);
            // 增量序列
            path.add(nums[i]);
            // 纵向遍历
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }

    }
}
// @lc code=end
