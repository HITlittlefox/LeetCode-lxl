import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 前序遍历
        // 入栈顺序:中右左,出栈顺序是中左右
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode nodeTemp = stack.pop();
            result.add(nodeTemp.val);
            // if (root.right != null) {
            // stack.push(root.right);
            // }
            // if (root.left != null) {
            // stack.push(root.left);
            // }

            // 应该看栈中弹出的节点的左右孩子节点,而不是root的左右孩子节点
            if (nodeTemp.right != null) {
                stack.push(nodeTemp.right);
            }
            if (nodeTemp.left != null) {
                stack.push(nodeTemp.left);
            }
        }
        return result;
    }
}
// @lc code=end
