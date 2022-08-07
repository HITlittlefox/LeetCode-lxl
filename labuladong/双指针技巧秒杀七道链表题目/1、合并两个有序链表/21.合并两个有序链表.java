/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 比较p1和p2两个指针
        // 将值较小的节点接到cur指针
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                // list2小
                cur.next = list2;
                list2 = list2.next;
            } else {
                // list1小
                cur.next = list1;
                list1 = list1.next;
            }
            // cur指针前进
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }
}
// @lc code=end
