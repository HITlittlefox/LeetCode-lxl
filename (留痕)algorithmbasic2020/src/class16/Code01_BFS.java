package class16;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code01_BFS {

    // 从node出发，进行宽度优先遍历
    // 从node出发，进行宽度优先遍历
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        // 图需要用set结构，因为图相比于二叉树有可能存在环
        // 即有可能存在某个点多次进入队列的情况
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                // 直接邻居，没有进入过Set的进入Set和队列
                // 用set限制队列的元素，防止有环队列一直会加入元素
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

}