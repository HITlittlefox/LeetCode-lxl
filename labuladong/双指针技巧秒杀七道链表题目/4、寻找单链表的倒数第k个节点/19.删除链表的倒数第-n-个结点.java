/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
class Solution {
    // 主函数
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    private ListNode findFromEnd(ListNode head, int k) {
        ListNode fast = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        // p1 和 p2 同时走 n - k 步
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
        return slow;
    }
}
// @lc code=end
