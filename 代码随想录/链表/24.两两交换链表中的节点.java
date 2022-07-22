import java.util.Stack;

/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
// 虚拟头结点
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 虚拟头结点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        // 如果要交换两个节点A和B的位置,需要拿到A的前一个节点和A节点
        while (prev.next != null && prev.next.next != null) {
            
            // prev->dummy AB CD EF
            // 缓存 next (缓存C)
            ListNode temp = head.next.next;
            
            // 将 prev 的 next 改为 head 的 next  
            // dummy.next=B 
            prev.next = head.next;
            
            // 将 head.next(prev.next) 的next，指向 
            // dummy B A
            head.next.next = head;
            
            // 将head 的 next 接上缓存的temp
            // dummy B A C (此时,head)
            head.next = temp;

            // 步进1位 
            // 此时,head指向A;A是C的前一位,A也就是C的prev
            prev = head;
            // 步进1位
            // C的前一位拿到了,现在来到了C
            head = head.next;
        }
        return dummyNode.next;
    }
}
*/
/* 

// 递归的写法就更简洁了，实际上利用了回溯的思想，递归遍历到链表末尾，然后先交换末尾两个，然后依次往前交换：
class Solution {
    public ListNode swapPairs(ListNode head) {
        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
} 
*/
/* 

// 利用stack 我们利用一个 stack，然后不断迭代链表，每次取出两个节点放入 stack 中，再从 stack 中拿出两个节点。借助 stack 后进先出的特点，放进去的时候是 1,2 。拿出来的时候就是 2，1 两个节点了。再把这两个节点串联起来，重复这个逻辑遍历完整个链表
class Solution {
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		//用stack保存每次迭代的两个节点
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode p = new ListNode(-1);
		ListNode cur = head;
		//head指向新的p节点，函数结束时返回head.next即可
		head = p;
		while(cur!=null && cur.next!=null) {
			//将两个节点放入stack中
			stack.add(cur);
			stack.add(cur.next);
			//当前节点往前走两步
			cur = cur.next.next;
			//从stack中弹出两个节点，然后用p节点指向新弹出的两个节点
			p.next = stack.pop();
			p = p.next;
			p.next = stack.pop();
			p = p.next;
		}
		//注意边界条件，当链表长度是奇数时，cur就不为空
		if(cur!=null) {
			p.next = cur;
		} else {
			p.next = null;
		}
		return head.next;
	}
}


*/
// [图解] 24. 两两交换链表中的节点，递归 + 迭代解法~ - 两两交换链表中的节点 - 力扣（LeetCode） 
// https://leetcode.cn/problems/swap-nodes-in-pairs/solution/tu-jie-24-liang-liang-jiao-huan-lian-bia-63fj/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
// @lc code=end
