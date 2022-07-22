package 路径总和;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSumRecursion(root, targetSum);
        return res;
    }

    void pathSumRecursion(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        // 需要对每个节点进行前序处理,但是吧,需要进行回溯(后序)
        // Inserts the specified element at the end of this deque
        path.offerLast(root.val);
        targetSum = targetSum - root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<Integer>(path));
        }

        pathSumRecursion(root.left, targetSum);
        pathSumRecursion(root.right, targetSum);

        // 需要进行回溯(后序)
        // Retrieves and removes the last element of this deque
        path.pollLast();
    }
}

// @lc code=end
