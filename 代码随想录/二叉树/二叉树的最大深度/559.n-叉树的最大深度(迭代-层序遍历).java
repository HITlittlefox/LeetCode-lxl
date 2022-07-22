package 二叉树的最大深度;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // public int maxDepth(Node root) {

    // }

    // public List<List<Integer>> result = new ArrayList<>();

    public int maxDepth(Node root) {

        return levelOrderIteration(root);
    }

    int levelOrderIteration(Node node) {
        if (node == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int depth = 0;
        while (!queue.isEmpty()) {
            // List<Integer> deepItemsList = new ArrayList<>();
            int len = queue.size();
            depth++;
            while (len > 0) {
                Node temp = queue.poll();
                // deepItemsList.add(temp.val);
                int childrenNum = 0;
                while (childrenNum < temp.children.size()) {
                    queue.add(temp.children.get(childrenNum));
                    childrenNum++;
                }
                len--;
            }

        }
        return depth;
    }
}
// @lc code=end
