/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        if (head.next.next == head) {
            return head;
        }

        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
            if (fast == null || fast.next == null) {
                return null;
            }

        }
        fast = head;

        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
}
// @lc code=end
