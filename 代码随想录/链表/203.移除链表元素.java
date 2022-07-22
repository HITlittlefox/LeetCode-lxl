
/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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

// 不添加虚拟节点方式
// head抓住非目标值的头节点
// cur 慢指针
// jump 快指针
// 时间复杂度 O(n)
// 空间复杂度 O(1)

class Solution {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 已经为null，提前退出
        if (head == null) {
            return head;
        }
        // 此时head.val!=val
        // 此时head!=null
        ListNode cur = head;
        ListNode jump = head.next;
        while (jump != null) {
            if (jump.val == val) {
                cur.next = jump.next;
            } else {
                cur = jump;
            }
            jump = jump.next;
        }
        return head;
    }

}
 */

/*
//  * 不添加虚拟节点and pre Node方式
//    head抓住非目标值的头节点
//    直接考虑当前节点的下一个节点的值
//  * 时间复杂度 O(n)
//  * 空间复杂度 O(1)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
} */

/* 
//  * 添加虚节点方式
//  * 时间复杂度 O(n)
//  * 空间复杂度 O(1)
//  * @param head
//  * @param val
//  * @return
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        // 虚拟的头节点,可以方便拿头
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
*/
// @lc code=end
