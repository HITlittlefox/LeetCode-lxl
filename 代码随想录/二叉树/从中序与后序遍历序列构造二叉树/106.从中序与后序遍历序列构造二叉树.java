package 从中序与后序遍历序列构造二叉树;
/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 左闭右开
        return buildTree1(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    /**
     * @param inorder中序打印
     * @param inLeft
     * @param inRight
     * @param postorder后序打印
     * @param postLeft
     * @param postRight
     * @return
     */
    private TreeNode buildTree1(int[] inorder, int inLeft, int inRight,
            int[] postorder, int postLeft, int postRight) {

        // 一定先拿到后序数组最后一个值,也就是本轮的根节点,去处理中序数组

        // 没有元素了
        if (inRight - inLeft < 1) {
            return null;
        }
        // 只有一个元素了
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        // 后序数组postorder里最后一个即为根结点
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);

        // 根据根结点的值找到该值在中序数组inorder里的位置
        int rootIndex = 0;
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        // 根据rootIndex划分左右子树
        // 左子树:中序左子树+后序左子树
        root.left = buildTree1(inorder, inLeft, rootIndex,
                postorder, postLeft, postLeft + (rootIndex - inLeft));
        // 右子树:中序右子树+后序右子树
        root.right = buildTree1(inorder, rootIndex + 1, inRight,
                postorder, postLeft + (rootIndex - inLeft), postRight - 1);
        return root;
    }
}
// @lc code=end
