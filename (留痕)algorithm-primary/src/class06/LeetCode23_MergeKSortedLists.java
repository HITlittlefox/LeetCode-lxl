package class06;

import java.util.Comparator;
import java.util.PriorityQueue;

// 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
public class LeetCode23_MergeKSortedLists {

	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static class ListNodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			// o1.val < o2.val , 则返回负数，也就是第一个参数在前面，小根堆。
			return o1.val - o2.val;
		}

	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}
		// 使用小根堆，把头挨个塞入，每次弹出后自动塞入头的下一个，进入后自动排序
		// 需要自己写一个ListNode的比较器，也就是：ListNodeComparator
		PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				heap.add(lists[i]);
			}
		}
		if (heap.isEmpty()) {
			return null;
		}
		ListNode head = heap.poll();
		ListNode pre = head;
		if (pre.next != null) {
			heap.add(pre.next);
		}
		while (!heap.isEmpty()) {
			ListNode cur = heap.poll();
			// 先拿到弹出节点的下一个
			pre.next = cur;
			pre = cur;
			if (cur.next != null) {
				heap.add(cur.next);
			}
		}
		return head;
	}

}
