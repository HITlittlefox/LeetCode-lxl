// 138. 复制带随机指针的链表

import java.util.*;

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode dummy = new RandomListNode(0);
        dummy.next = pHead;

        Map<Integer, Integer> mapNext = new HashMap<>();
        Map<Integer, Integer> mapRandom = new HashMap<>();

        int count = 0;

        while (pHead.next != null) {
            mapNext.put(pHead.label, pHead.next.label);
            pHead = pHead.next;
            count++;
            if (pHead.next == null) {
                mapNext.put(pHead.label, null);
                count++;
                break;
            }
        }

        // System.out.println("count1:" + count);
        pHead = dummy.next;
        int count2 = 0;
        while (pHead != null) {
            if (pHead.random != null) {
                count2++;
                mapRandom.put(pHead.label, pHead.random.label);

            }
            pHead = pHead.next;
        }
        // System.out.println("count2:" + count2);
        // // System.out.println("mapRandom.get(4):" + mapRandom.get(4));
        // System.out.println("====");

        pHead = dummy.next;

        RandomListNode dummy2 = new RandomListNode(-2);
        RandomListNode res = new RandomListNode(pHead.label);
        dummy2.next = res;
        // System.out.println(pHead.label);

        // System.out.println(mapNext.get(1));
        // System.out.println(mapNext.get(2));
        // System.out.println(mapNext.get(3));
        // System.out.println(mapNext.get(4));
        // System.out.println(mapNext.get(5));
        // System.out.println("===");

        for (int i = 0; i < count; i++) {
            // System.out.println(i);
            if (mapNext.get(res.label) != null) {
                int temp = mapNext.get(res.label);
                res.next = new RandomListNode(temp);
                res = res.next;
            } else {
                res.next = null;
                break;
            }
        }
        // System.out.println("===");

        res = dummy2.next;
        while (res != null) {
            // System.out.println(res.label);
            res = res.next;
        }
        res = dummy2.next;
        // System.out.println("===");

        while (res != null) {
            // System.out.println(i);
            if (mapRandom.get(res.label) != null) {
                int temp = mapRandom.get(res.label);
                res.random = new RandomListNode(temp);
            }
            res = res.next;
        }
        // System.out.println("===");

        res = dummy2.next;
        while (res != null) {
            if (res.random != null) {
                System.out.println(res.random.label);
            }
            res = res.next;
        }
        return dummy2.next;
    }
}