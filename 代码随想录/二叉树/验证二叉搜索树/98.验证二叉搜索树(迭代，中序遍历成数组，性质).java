package 验证二叉搜索树;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
// 迭代
// 如果是二叉搜索树,中序遍历结果的数组,需要严格的从小到大(并且没有相等)
class Solution {
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorder(root);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
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
