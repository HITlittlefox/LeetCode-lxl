/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start

// Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        // ListNode dummy = new ListNode(-1);
        // dummy.next = head;
        if (head == null) {
            return null;
        }
        ListNode cur = head.next == null ? null : head.next;
        ListNode temp = cur == null ? null : cur;
        ListNode pre = null;

        // 两个及以上节点
        while (temp != null) {
            // if (temp.next == null) {
            // break;
            // }
            temp = cur.next;
            cur.next = head;
            head.next = pre;
            pre = head;
            head = cur;
            cur = temp;
        }
        // head.next = pre;
        return head;

    }
}
// @lc code=end
