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

/*
 * // 分情况讨论
 * class Solution {
 * public ListNode removeNthFromEnd(ListNode head, int n) {
 * ListNode curForCount = head;
 * int count = 0;
 * while (curForCount != null) {
 * curForCount = curForCount.next;
 * count++;
 * } // 获得链表个数 count
 * // System.out.println("count=" + count);
 * ListNode pre = head;
 * head = head.next;
 * if (count == 1) {
 * return null;
 * }
 * if (count == 2) {
 * if (n == 1) {
 * pre.next = head.next;
 * return pre;
 * }
 * if (n == 2) {
 * pre.next = null;
 * pre = head;
 * return pre;
 * }
 * }
 * if (count >= 3) {
 * if (count - n == 0) {
 * pre.next = null;
 * pre = head;
 * return pre;
 * }
 * if (count - n == 1) {
 * pre.next = head.next;
 * return pre;
 * }
 * if (count - n == 2) {
 * head.next = head.next.next;
 * return pre;
 * }
 * int newCount = count - n - 2;
 * 
 * while (newCount-- != 0) {
 * head = head.next;
 * System.out.println("head移动");
 * }
 * head.next = head.next.next;
 * return pre;
 * 
 * }
 * 
 * return pre;
 * 
 * }
 * }
 * 
 */

// 双指针
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
// @lc code=end
