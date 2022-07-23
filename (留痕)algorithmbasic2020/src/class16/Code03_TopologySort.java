package class16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code03_TopologySort {

    // 有向无环图，返回拓扑排序的顺序list
    public static List<Node> sortedTopology(Graph graph) {

        // key：某一个node
        // value：该节点剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();

        // 只有剩余入度为0的点，才能进这个队列
        Queue<Node> zeroInQueue = new LinkedList<>();

        // 拿到该图中所有的点集
        for (Node node : graph.nodes.values()) {
            // 初始化每个点，每个点的入度是原始节点的入度信息
            // 加入inMap
            inMap.put(node, node.in);
            // 由于是有向无环图，则必定有入度为0的起始点。放入到zeroInQueue
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        // 拓扑排序的结果，依次加入result
        List<Node> result = new ArrayList<>();

        while (!zeroInQueue.isEmpty()) {
            // 该有向无环图初始入度为0的点，直接弹出放入结果集中
            Node cur = zeroInQueue.poll();
            result.add(cur);
            // 该节点的下一层邻居节点，更新：入度减1
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                // 如果下一层存在入度变为0的节点，加入到0入度的队列中
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}