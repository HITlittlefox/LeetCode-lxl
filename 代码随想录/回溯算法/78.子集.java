import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        backtracking(nums, 0);
        return res;
    }

    // 递归函数参数
    // 数组
    // 起始下标
    void backtracking(int[] nums, int startIndex) {
        // 遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合。
        res.add(new ArrayList<>(path));

        // 可以不写终止条件，因为本来我们就要遍历整棵树。
        // 有的同学可能担心不写终止条件会不会无限递归？
        // 并不会，因为每次递归的下一层就是从 i+1 开始的。
        // if (startIndex >= nums.length) {
        // // res.add(new ArrayList<>(path));
        // return;
        // }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
