package 思路;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
/*
 * 这题能不能用「分解问题」的思维模式解决？
 * 我们尝试给出 flatten 函数的定义:
 * 有了这个函数定义，如何按题目要求把一棵树拉平成一条链表？
 * 对于一个节点 x，可以执行以下流程：
 * 1、先利用 flatten(x.left) 和 flatten(x.right) 将 x 的左右子树拉平。
 * 2、将 x 的右子树接到左子树下方，然后将整个左子树作为右子树。
 */
class Solution {
    public void flatten(TreeNode root) {
        // base case
        if (root == null)
            return;
        // 对于一个节点 x，可以执行以下流程：
        // 1、先针对左和右,都进行 flatten(x.left) 和 flatten(x.right) 。
        flatten(root.left);
        flatten(root.right);

        // 2、将 x 的右子树接到左子树下方，然后将整个左子树作为右子树。
        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        // p.right是左子树移花接木后在右子树的最右下的位置
        p.right = right;
    }
}
// @lc code=end
