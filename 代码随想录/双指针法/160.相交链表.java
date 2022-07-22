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
// 双指针,先同时从长短两线往后遍历,直到某一个已经结束,
// 然后让长线继续走,并且安排一个指针从长线头同时走
// 结束的时候,长线新头和短线新头都还剩相同长度,挨个走并比较

// 类似思路:先计算两条链表的长度，然后让 p1 和 p2 距离链表尾部的距离相同，然后齐头并进
/* class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode dummyA = new ListNode(-1);
        dummyA.next = headA;
        ListNode dummyB = new ListNode(-2);
        dummyB.next = headB;
        // A短,B长
        ListNode curLong = headB;
        ListNode curShort = headA;

        while (headA.next != null && headB.next != null) {
            // System.out.println("??");
            headA = headA.next;
            headB = headB.next;
        }
        System.out.println("完成第一轮");
        // A短,B长
        if (headA.next == null) {
            System.out.println("Blong");
            while (headB.next != null) {
                // System.out.println(headB.val);
                headB = headB.next;
                curLong = curLong.next;
            }
        } else {// A长,B短
            curLong = dummyA.next;
            curShort = dummyB.next;
            System.out.println("Along");
            while (headA.next != null) {
                // System.out.println(headB.val);
                headA = headA.next;
                curLong = curLong.next;
            }
        }
        while (curShort != curLong) {
            // System.out.println("?");
            curLong = curLong.next;
            curShort = curShort.next;
        }
        if (curShort == curLong) {
            return curShort;
        } else {
            return null;
        }
    }

} */

// 让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起。
// 如果这样进行拼接，就可以让 p1 和 p2 同时进入公共部分，也就是同时到达相交节点 c1
/* class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null)
                p1 = headB;
            else
                p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null)
                p2 = headA;
            else
                p2 = p2.next;
        }
        // 总能循环到交叉节点,或者循环到都是null
        return p1;
    }
} */


class Solution {
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
            // 1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            // 2. swap (curA, curB);
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

}
// @lc code=end
