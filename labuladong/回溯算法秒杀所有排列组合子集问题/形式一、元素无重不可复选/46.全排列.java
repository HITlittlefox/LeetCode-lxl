import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> path = new LinkedList<>();
    // track 中的元素会被标记为 true
    boolean[] used;

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    // 回溯算法核心函数
    void backtracking(int[] nums) {
        // base case，到达叶子节点
        if (path.size() == nums.length) {
            // 收集叶子节点上的值
            res.add(new LinkedList<>(path));
            return;
        }

        // 回溯算法标准框架
        for (int i = 0; i < nums.length; i++) {
            // 已经存在 track 中的元素，不能重复选择
            if (used[i]) {
                continue;
            }
            // 做选择
            used[i] = true;
            path.addLast(nums[i]);
            // 进入下一层回溯树
            backtracking(nums);
            // 取消选择
            path.removeLast();
            used[i] = false;
        }
    }

}
// @lc code=end


/* 
 * 如果题目不让你算全排列，而是让你算元素个数为 k 的排列，怎么算？
 * 改下 backtrack 函数的 base case，仅收集第 k 层的节点值即可：
 */
// // 回溯算法核心函数
// void backtrack(int[] nums, int k) {
//     // base case，到达第 k 层，收集节点的值
//     if (track.size() == k) {
//         // 第 k 层节点的值就是大小为 k 的排列
//         res.add(new LinkedList(track));
//         return;
//     }

//     // 回溯算法标准框架
//     for (int i = 0; i < nums.length; i++) {
//         // ...
//         backtrack(nums, k);
//         // ...
//     }
// }