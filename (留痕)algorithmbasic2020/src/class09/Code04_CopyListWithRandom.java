package class09;

import java.util.HashMap;

// 测试链接 : https://leetcode.com/problems/copy-list-with-random-pointer/
public class Code04_CopyListWithRandom {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList1(Node head) {
        // key 老节点
        // value 新节点
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }// 每一个老节点的新节点都克隆好了，并且都存在map里

        // 头节点
        cur = head;
        while (cur != null) {
            // cur 老
            // map.get(cur) 新
            // 新.next ->  cur.next克隆节点找到

            // cur的克隆节点的next指针，指向，cur的next指针指的节点的克隆节点
            map.get(cur).next = map.get(cur.next);
            // cur的克隆节点的random指针，指向，cur的random指针指的节点的克隆节点
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回克隆结构
        return map.get(head);
    }

    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        // 1 -> 2 -> 3 -> null
        // 1 -> 1' -> 2 -> 2' -> 3 -> 3'
        while (cur != null) {
            // next：老节点的下一个
            // cur 老节点
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }// 完成插入
        cur = head;
        Node copy = null;
        // 1 1' 2 2' 3 3'
        // 依次设置 1' 2' 3' random指针
        while (cur != null) {
            // 老节点的下一个的下一个，也就是原链表中老节点的下一个
            next = cur.next.next;
            // 克隆节点
            copy = cur.next;
            // 如果老节点的random不为空
            copy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        // 克隆链表的头节点
        Node res = head.next;
        // 原链表的正常节点
        cur = head;
        // 老 新 混在一起，next方向上，random正确
        // next方向上，把新老链表分离
        while (cur != null) {
            // 保存，老节点的正常下一个
            next = cur.next.next;
            // 保存，新链表的下一个
            copy = cur.next;
            // 老节点头节点指向正常下一个
            cur.next = next;
            // 如果next != 空，就指向next的next，也就是新节点的下一个，否则就空
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        // 返回克隆链表的头部
        return res;
    }

}
