/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1, l2, 0);
    }

    ListNode dfs(ListNode l, ListNode r, int i) {
        if (l == null && r == null && i == 0) {
            return null;
        }
        int sum = (l != null ? l.val : 0) + (r != null ? r.val : 0) + i;
       
        ListNode node = new ListNode(sum % 10);
        node.next = dfs(l != null ? l.next : null, r != null ? r.next : null, sum / 10);
        return node;
    }
}
// @lc code=end
