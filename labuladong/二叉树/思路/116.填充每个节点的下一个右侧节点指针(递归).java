package 思路;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    void dfs(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;
        // 配合动画演示理解这段，以root为起点，将整个纵深这段串联起来
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        // 递归的调用左右节点，完成同样的纵深串联
        dfs(root.left);
        dfs(root.right);
    }
}
// @lc code=end
