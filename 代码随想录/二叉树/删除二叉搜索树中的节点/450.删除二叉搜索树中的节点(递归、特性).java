package 删除二叉搜索树中的节点;
/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 */

// @lc code=start
class Solution {

    // 返回的是移花接木好的节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key > root.val) {// 去右子树删除
            root.right = deleteNode(root.right, key);
        }

        else if (key < root.val) {// 去左子树删除
            root.left = deleteNode(root.left, key);
        }

        else { // 当前节点就是要删除的节点
            if (root.left == null) {
                // 情况1，欲删除节点无左子
                return root.right;
            } else if (root.right == null) {
                // 情况2，欲删除节点无右子
                return root.left;
            } else if (root.left != null && root.right != null) { // 情况3，欲删除节点左右子都有
                TreeNode node = root.right;
                while (node.left != null) {
                    // 寻找欲删除节点右子树的最左节点
                    node = node.left;
                }

                node.left = root.left; // 将欲删除节点的左子树成为其右子树的最左节点的左子树
                root = root.right; // 欲删除节点的右子顶替其位置，节点被删除
            }
        }
        return root;
    }
}
// @lc code=end
