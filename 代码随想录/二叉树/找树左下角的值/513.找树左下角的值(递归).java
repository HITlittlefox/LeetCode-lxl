package 找树左下角的值;
/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
class Solution {
    // 维护两个深度，一个是当前的遍历到的最大深度 maxDepth，
    // 另一个是当前节点所处的深度 leftDepth。
    private int maxDepth = -1;
    private int res = 0;

    public int findBottomLeftValue(TreeNode root) {

        // 确定递归函数的参数和返回值
        // 参数必须有要遍历的树的根节点，
        // 还有就是一个 int 型的变量用来记录最长深度。
        res = root.val;
        // 如果需要遍历整棵树，递归函数就不能有返回值。如果需要遍历某一条固定路线，递归函数就一定要有返回值！
        // 本题我们是要遍历整个树找到最深的叶子节点，需要遍历整棵树，所以递归函数没有返回值。
        traverse(root, 0);
        return res;
    }

    private void traverse(TreeNode node, int leftDepth) {
        if (node == null)
            return;
        // 如果当前节点是叶子节点
        if (node.left == null && node.right == null) {
            // 当前叶子节点的深度大于之前保存的最大深度
            // 证明是当前深度的最左边叶子节点，因为先递归左子树
            // 此时更新最大深度，更新结果值
            if (leftDepth > maxDepth) {
                // 更新
                maxDepth = leftDepth;
                res = node.val;
            }
        }
        traverse(node.left, leftDepth + 1);
        traverse(node.right, leftDepth + 1);

    }
}
// @lc code=end
