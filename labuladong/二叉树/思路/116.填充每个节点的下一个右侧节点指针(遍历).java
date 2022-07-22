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
/* 1、这题能不能用「遍历」的思维模式解决？
很显然，一定可以。
每个节点要做的事也很简单，把自己的 next 指针指向右侧节点就行了。
也许你会模仿上一道题，直接写出如下代码： */
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        // 遍历「三叉树」，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }

        /**** 前序位置 ****/
        // 将传入的两个节点穿起来
        left.next = right;

        // 连接相同父节点的两个子节点
        traverse(left.left, left.right);
        traverse(right.left, right.right);
        // 连接跨越父节点的两个子节点
        traverse(left.right, right.left);
    }
}
// @lc code=end
