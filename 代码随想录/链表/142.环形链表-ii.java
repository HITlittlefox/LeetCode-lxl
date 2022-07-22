import java.util.List;

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
/*
 * class Solution {
 * public ListNode detectCycle(ListNode head) {
 * ListNode dummy = new ListNode(-1);
 * dummy.next = head;
 * 
 * if (head == null) {
 * return null;
 * }
 * if (head.next == null) {
 * return null;
 * }
 * if (head.next.next == null) {
 * return null;
 * }
 * if (head.next.next == head) {
 * return head;
 * }
 * if (head.next.next.next == null) {
 * return null;
 * }
 * 
 * if (head.next.next.next == head) {
 * return head;
 * }
 * 
 * // ListNode curForCount = head;
 * // int count = 0;
 * // while (curForCount != null) {
 * // curForCount = curForCount.next;
 * // count++;
 * // } // 获得链表个数 count
 * // System.out.println("count=" + count);
 * 
 * ListNode fast = head.next.next;
 * ListNode slow = head.next;
 * while (fast != null) {
 * if (fast.toString().equals(slow.toString())) {
 * break;
 * }
 * if (slow.next == null) {
 * return null;
 * }
 * if (fast.next == null || fast.next.next == null) {
 * return null;
 * }
 * 
 * fast = fast.next.next;
 * slow = slow.next;
 * 
 * }
 * fast = dummy.next;
 * while (fast != null) {
 * if (fast.toString().equals(slow.toString())) {
 * return fast;
 * }
 * fast = fast.next;
 * slow = slow.next;
 * }
 * return fast;
 * 
 * }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = dummy.next;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}

// @lc code=end
