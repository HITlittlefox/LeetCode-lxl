package 左叶子之和;
/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 */

// @lc code=start
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesRecursion(root);
    }

    // 确定递归函数的参数和返回值
    private int sumOfLeftLeavesRecursion(TreeNode node) {
        // 确定终止条件
        if (node == null) {
            return 0;
        }
        // 确定单层递归的逻辑:当遇到左叶子节点的时候，记录数值，然后通过递归求取左子树左叶子之和，和 右子树左叶子之和，相加便是整个树的左叶子之和。

        // 通过节点的父节点来判断其左孩子是不是左叶子
        int leftValue = sumOfLeftLeavesRecursion(node.left);
        int rightValue = sumOfLeftLeavesRecursion(node.right);

        // 需要拿到该节点的左右孩子的值,才能做决定,所以是后序
        int midValue = 0;

        if (node.left != null && node.left.left == null && node.left.right == null) {
            // 符合条件的,是9,也就是root的左下角节点没有左右孩子,也就是左叶子节点
            midValue = node.left.val;
        }
        int sum = midValue + leftValue + rightValue;

        return sum;
    }

}
// @lc code=end
