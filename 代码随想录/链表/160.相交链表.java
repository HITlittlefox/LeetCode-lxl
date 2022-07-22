
/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
// 思路1:先比较最后一个位置的地址是否相同
// 如果相同,则有相交点,否则没有.
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = new ListNode(-1);
        ListNode dummyB = new ListNode(-2);
        dummyA.next = headA;
        dummyB.next = headB;
        int lenghtofA = 1;
        int lenghtofB = 1;
        while (headA.next != null) {
            headA = headA.next;
            lenghtofA++;
        } // head指向最后一个

        String lastofA = headA.toString();
        while (headB.next != null) {
            headB = headB.next;
            lenghtofB++;
        } // head指向最后一个[]

        String lastofB = headB.toString();

        if (!lastofA.equals(lastofB)) {
            return null;
        }

        int locOfIntersectVal = 0;
        int sameSize = Math.min(lenghtofB, lenghtofA);
        ListNode preForIntersect = dummyA.next;
        ListNode lastForIntersect = dummyB.next;
        if (lenghtofA - lenghtofB > 0) {
            locOfIntersectVal = lenghtofA - lenghtofB;

            preForIntersect = dummyA.next;
            lastForIntersect = dummyB.next;
        }
        if (lenghtofA - lenghtofB < 0) {
            locOfIntersectVal = lenghtofB - lenghtofA;

            preForIntersect = dummyB.next;
            lastForIntersect = dummyA.next;
        }

        while (locOfIntersectVal-- != 0) {
            preForIntersect = preForIntersect.next;
        }

        while (sameSize-- != 0) {
            if (preForIntersect.toString().equals(lastForIntersect.toString())) {
                return preForIntersect;

            }
            preForIntersect = preForIntersect.next;
            lastForIntersect = lastForIntersect.next;
        }
        return preForIntersect;
    }
}

/* 
// 从前往后,先到同一起跑线,再挨个比较地址
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
    
} */
// @lc code=end
