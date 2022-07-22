import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start

// Definition for a binary tree node.

class Solution {

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        // levelOrderRecursion(root, 0);
        // levelOrderIteration(root);
        levelOrderIteration(root);
        return resList;
    }

    // DFS--递归方式
    void levelOrderRecursion(TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }

        // 层 deep=1
        deep++;
        // 如果二维列表数＜深度,为二维列表开辟新空间
        if (resList.size() < deep) {
            // 当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> deepItem = new ArrayList<Integer>();
            resList.add(deepItem);
        }

        // [[3],
        // resList的0空间,添加第1层的数,也就是node.val
        // 为二维列表的一维列表添加值
        resList.get(deep - 1).add(node.val);

        levelOrderRecursion(node.left, deep);// [[3],[9,
        levelOrderRecursion(node.right, deep);// [[3],[9,20],
    }

    // BFS--迭代方式--借助队列
    public void levelOrderIteration(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 先添加一个
        queue.add(node);

        while (!queue.isEmpty()) {
            List<Integer> deepItemList = new ArrayList<Integer>();
            int len = queue.size();
            // len=1
            while (len > 0) {
                TreeNode temp = queue.poll();
                deepItemList.add(temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                len--;
            }
            resList.add(deepItemList);
        }
    }

}
// @lc code=end
