import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// 非递归
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 前序遍历
        // 入栈顺序:中左右,出栈顺序是中右左,再反转变成左右中
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode nodeTemp = stack.pop();
            result.add(nodeTemp.val);
            // 应该看栈中弹出的节点的左右孩子节点,而不是root的左右孩子节点
            if (nodeTemp.left != null) {
                stack.push(nodeTemp.left);
            }
            if (nodeTemp.right != null) {
                stack.push(nodeTemp.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
// @lc code=end
