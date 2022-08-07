package class04;

// 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
public class Code06_MergeTwoSortedLinkedList {

	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int num) {
			val = num;
			next = null;
		}
	}

	public static void main(String[] args) {

		int num = (int) (Math.random() * 9) + 1;
		ListNode node = new ListNode(num);
		System.out.print(num + " ");
		ListNode node1 = node;
		for (int i = 1; i <= num; i++) {
			int num1 = i + num;
			System.out.print(num1 + " ");
			node.next = new ListNode(num1);
			node = node.next;
		}

		System.out.println();

		int num2 = (int) (Math.random() * 9) + 1;
		ListNode node2 = new ListNode(num2);
		System.out.print(num2 + " ");
		ListNode node3 = node2;
		for (int i = 1; i <= num2; i++) {
			int num1 = i + num2;
			System.out.print(num1 + " ");
			node2.next = new ListNode(num1);
			node2 = node2.next;
		}
		System.out.println();

		ListNode listNode = mergeTwoLists(node1, node3);
		while (listNode != null) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}
		// 返回两个链表head中最小的作为总头部
		ListNode head = head1.val <= head2.val ? head1 : head2;
		// 小头的下一个，是cur1
		ListNode cur1 = head.next;
		// 大头的第一个，是cur2
		ListNode cur2 = head == head1 ? head2 : head1;
		// pre也指向head
		ListNode pre = head;

		while (cur1 != null && cur2 != null) {
			// 如果小头的下一个<大头
			// 小cur，让pre的next指，并且cur走到下一个
			if (cur1.val <= cur2.val) {
				// 小头的下一个，就是小头的下一个
				pre.next = cur1;
				cur1 = cur1.next;
			} else {
				pre.next = cur2;
				cur2 = cur2.next;
			}
			pre = pre.next;
		}
		pre.next = cur1 != null ? cur1 : cur2;
		return head;
	}

}
