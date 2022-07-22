package 合并二叉树;
/*
 * @lc app=leetcode.cn id=617 lang=java
 *
 * [617] 合并二叉树
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
// 递归
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();
            // 都不为空,相加即可
            temp1.val = temp1.val + temp2.val;

            // 如果两棵树左节点都不为空，加入队列
            if (temp1.left != null && temp2.left != null) {
                queue.offer(temp1.left);
                queue.offer(temp2.left);
            }
            // 如果两棵树右节点都不为空，加入队列
            if (temp1.right != null && temp2.right != null) {
                queue.offer(temp1.right);
                queue.offer(temp2.right);
            }
            // 若node1的左节点为空，直接赋值
            if (temp1.left == null && temp2.left != null) {
                temp1.left = temp2.left;
            }
            // 若node2的左节点为空，直接赋值
            if (temp1.right == null && temp2.right != null) {
                temp1.right = temp2.right;
            }
        }
        return root1;
    }
}
// @lc code=end
