/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = head;
        while (n-- != 0) {
            // 走n步
            fast = fast.next;
            // 删除倒数第n个节点
            if (fast == null) {
                dummy.next = head.next;
                return dummy.next;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        } // 结束时,slow指向倒数第n数的前一位

        slow.next = slow.next.next;
        return dummy.next;

    }
}
// @lc code=end
