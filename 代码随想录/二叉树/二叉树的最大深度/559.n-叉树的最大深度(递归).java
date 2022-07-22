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
*/
// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {
//     }

//     public Node(int _val) {
//         val = _val;
//     }

//     public Node(int _val, List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// };

class Solution {
    // public int maxDepth(Node root) {

    // }

    // public List<List<Integer>> result = new ArrayList<>();

    public int maxDepth(Node root) {
        return maxDepthRecursion(root);
    }

    int maxDepthRecursion(Node node) {
        if (node == null) {
            return 0;
        }
        int depth = 0;
        if (node.children != null) {
            for (Node child : node.children) {
                depth = Math.max(depth, maxDepth(child));
            }
        }
        return depth + 1;
    }
}
// @lc code=end
