package 二叉搜索树中的众数;
/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        // 左中右
        inorder(root);

        int numCountMax = 0;
        int resultLen = 0;
        for (int i : map.values()) {
            if (i == numCountMax) {
                resultLen++;
                continue;
            }
            if (i > numCountMax) {
                numCountMax = i;
                resultLen = 1;
            }

        }
        int[] result = new int[resultLen];
        int k = 0;
        for (int j : map.keySet()) {
            if (map.get(j) == numCountMax) {
                result[k] = j;
                k++;
            }

        }

        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(root.val)) {
            map.put(root.val, 1);
        } else if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        }
        inorder(root.left);

        inorder(root.right);
    }
}
// @lc code=end
