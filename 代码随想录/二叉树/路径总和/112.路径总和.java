package 路径总和;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
 * 来看返回值，递归函数什么时候需要返回值？什么时候不需要返回值？这里总结如下三点：
 * 如果需要搜索整棵二叉树且不用处理递归返回值，递归函数就不要返回值。（这种情况就是本文下半部分介绍的 113. 路径总和 ii）
 * 如果需要搜索整棵二叉树且需要处理递归返回值，递归函数就需要返回值。 （这种情况我们在 236. 二叉树的最近公共祖先 (opens new
 * window)中介绍）
 * 如果要搜索其中一条符合条件的路径，那么递归一定需要返回值，因为遇到符合条件的路径了就要及时返回。（本题的情况）
 */

/*
 * class Solution {
 * public boolean hasPathSum(TreeNode root, int targetSum) {
 * // 确定递归函数的参数和返回类型
 * // 参数：需要二叉树的根节点，
 * // 还需要一个计数器，这个计数器用来计算二叉树的一条边之和是否正好是目标和，计数器为 int 型。
 * return hasPathSumRecursion(root, targetSum);
 * 
 * }
 * 
 * private boolean hasPathSumRecursion(TreeNode node, int targetSum) {
 * if (node == null) {
 * return false;
 * }
 * targetSum -= node.val;
 * // 叶子结点
 * if (node.left == null && node.right == null) {
 * return targetSum == 0;
 * }
 * if (node.left != null) {
 * // 之前已经将本节点值减去了
 * if (hasPathSumRecursion(node.left, targetSum) == true) {
 * return true;
 * }
 * }
 * if (node.right != null) {
 * // 之前已经将本节点值减去了
 * if (hasPathSumRecursion(node.right, targetSum) == true) {
 * return true;
 * }
 * }
 * return false;
 * }
 * }
 */

// 对于单个节点
// 进入节点就开测(前序)
// 1. 是否null
// 2. targetsum ? 0
// 3. 是否叶子节点
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum = targetSum - root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}

// @lc code=end
