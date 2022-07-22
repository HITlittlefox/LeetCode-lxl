
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
/* 
// 双指针
class Solution {
    public ListNode reverseList(ListNode head) {
        // 整个虚拟头吧
        ListNode pre = null;
        ListNode temp = null;
        while (head != null) {
            // temp先拿着下一个
            temp = head.next;
            head.next = pre;
            // 双指针往前滑动
            pre = head;
            head = temp;
        }
        return pre;

    }
}
*/
/*
// 递归 
class Solution {
    public ListNode reverseList(ListNode head) {
        // 翻转 null 和 head
        return reverse(null, head);
    }

    // 翻转 pre 和 cur
    private ListNode reverse(ListNode prev, ListNode cur) {
        // 如果cur是null了,也就是说,cur到了最后一位了
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, temp);
    }
}
*/


class Solution {
    public ListNode reverseList(ListNode head) {
        // 递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        // 若是1->2->3->4->5的情况
        // 可以理解为从2往后的都已经反转好了，现在是1->2<-3<-4<-5,
        // 现在只需要把1和后面那些反转就行了，这个cur现在是5
        ListNode cur = reverseList(head.next);
        // 2->1,得到1<=>2<-3<-4<-5,
        head.next.next = head;
        // 断开原来1和2之间的线,得到1<-2<-3<-4<-5,
        head.next = null;
        // 每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }
}
// @lc code=end
