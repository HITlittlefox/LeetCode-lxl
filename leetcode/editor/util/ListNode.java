//leetcode.editor.util.ListNode
package leetcode.editor.util;
import java.util.Arrays;
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode p = this;
        while (p != null) {
            sb.append(p.val).append(',');
            if (p.next == null) {
                sb.deleteCharAt(sb.length() - 1);
            }
            p = p.next;
        }
        return sb.append(']').toString();
    }
    /**
     * @param s 形如"1,2,3,4,5"的字符串
     * @return [1, 2, 3, 4, 5] 的头节点：1
     */
    public static ListNode of(String s) {
        if ("".equals(s)) return null;
        int[] array = Arrays.stream(s.split(",")).mapToInt(Integer::valueOf).toArray();
        return of(array);
    }
    public static ListNode of(int... array){
        ListNode _head = new ListNode(), p = _head;
        for (int i : array) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return _head.next;
    }
}
