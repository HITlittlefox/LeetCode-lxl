import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
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
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        levelOrderIteration(root);
        return result;
    }

    void levelOrderIteration(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            List<Integer> deepItemsList = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                Node temp = queue.poll();
                deepItemsList.add(temp.val);
                int childrenNum = 0;
                while (childrenNum < temp.children.size()) {
                    queue.add(temp.children.get(childrenNum));
                    childrenNum++;
                }
                len--;
            }
            result.add(deepItemsList);
        }

    }
}
// @lc code=end
