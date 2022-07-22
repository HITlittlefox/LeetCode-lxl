package 从中序与后序遍历序列构造二叉树;
/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder,
            int inOrderStart,
            int inorderEnd) {

        // preorder 为空，直接返回 null
        if (preOrderStart == preOrderEnd) {
            return null;
        }

        // 前序数组第一个数就是根节点
        int rootVal = preOrder[preOrderStart];
        TreeNode root = new TreeNode(rootVal);

        // 根据根结点的值找到该值在中序数组inorder里的位置
        // 在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = inOrderStart; i < inorderEnd; i++) {
            if (rootVal == inOrder[i]) {
                i_root_index = i;
                break;
            }
        }

        int leftNum = i_root_index - inOrderStart;

        // 构造左子树
        root.left = buildTreeHelper(preOrder, preOrderStart + 1, preOrderStart + leftNum + 1, inOrder, inOrderStart,
                i_root_index);
        // 构造右子树
        root.right = buildTreeHelper(preOrder, preOrderStart + leftNum + 1, preOrderEnd, inOrder,
                i_root_index + 1,
                inorderEnd);
        return root;
    }
}

/*
 * class Solution {
 * 
 * public TreeNode buildTree(int[] preorder, int[] inorder) {
 * return buildTreeHelper(preorder, 0, preorder.length, inorder, 0,
 * inorder.length);
 * }
 * 
 * private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end,
 * int[] inorder, int i_start, int i_end) {
 * // preorder 为空，直接返回 null
 * if (p_start == p_end) {
 * return null;
 * }
 * int root_val = preorder[p_start];
 * TreeNode root = new TreeNode(root_val);
 * // 在中序遍历中找到根节点的位置
 * int i_root_index = 0;
 * for (int i = i_start; i < i_end; i++) {
 * if (root_val == inorder[i]) {
 * i_root_index = i;
 * break;
 * }
 * }
 * int leftNum = i_root_index - i_start;
 * // 递归的构造左子树
 * root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1,
 * inorder, i_start, i_root_index);
 * // 递归的构造右子树
 * root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder,
 * i_root_index + 1, i_end);
 * return root;
 * }
 * }
 */

// @lc code=end
