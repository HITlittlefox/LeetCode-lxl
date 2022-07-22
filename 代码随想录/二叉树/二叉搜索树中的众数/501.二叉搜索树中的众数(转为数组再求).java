package 二叉搜索树中的众数;
/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    List<Integer> list = new ArrayList<>();
    List<Integer> res = new ArrayList<Integer>();

    public int[] findMode(TreeNode root) {
        // 左中右
        inorder(root);
        // 记录前一个元素值
        int pre = list.get(0);
        // 记录次数
        int cnt = 1;
        // 记录最大次数
        int maxCnt = 1;
        // 记录结果
        List<Integer> res = new ArrayList<Integer>();
        res.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            // 如果与前一个节点的值相等
            if (pre == list.get(i)) {
                cnt += 1;
            } else {
                cnt = 1;
            }
            // 如果和最大次数相同，将值放入 res
            if (cnt == maxCnt) {
                res.add(list.get(i));
            }
            // 如果大于最大次数
            else if (cnt > maxCnt) {
                // 更新最大次数
                maxCnt = cnt;
                // 重新更新 res
                res.clear();
                res.add(list.get(i));
            }
            pre = list.get(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
// @lc code=end
