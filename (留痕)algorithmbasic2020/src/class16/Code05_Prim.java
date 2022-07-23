package class16;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// undirected graph only
public class Code05_Prim {

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }

    }

    public static Set<Edge> primMST(Graph graph) {
        // 解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());

        // 哪些点被解锁出来了
        HashSet<Node> nodeSet = new HashSet<>();
        // 已经考虑过的边，不要重复考虑
        Set<Edge> edgeSet = new HashSet<>();
        // 依次挑选的的边在result里
        Set<Edge> result = new HashSet<>();
        // 随便挑了一个点,进入循环处理完后直接break
        for (Node node : graph.nodes.values()) {


            // node 是开始点
            if (!nodeSet.contains(node)) {
                // 开始节点保留
                nodeSet.add(node);

                // 开始节点的所有邻居节点全部放到小根堆
                // 即由一个点，解锁所有相连的边
                for (Edge edge : node.edges) {
                    // 没加入到小根堆的边，才会加入（最终，所有边都会加入）
                    if (!edgeSet.contains(edge)) {
                        edgeSet.add(edge);
                        priorityQueue.add(edge);
                    }
                }

                while (!priorityQueue.isEmpty()) {
                    // 弹出解锁的边中，最小的边
                    Edge edge = priorityQueue.poll();
                    // 可能的一个新的点,from已经被考虑了，只需要看to
                    Node toNode = edge.to;
                    // 如果发现to不在集合中，就是新的点，加入已解锁点集合，并且把边加入结果
                    if (!nodeSet.contains(toNode)) {
                        nodeSet.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            // 没加过的，放入小根堆
                            if (!edgeSet.contains(nextEdge)) {
                                edgeSet.add(nextEdge);
                                priorityQueue.add(nextEdge);
                            }
                        }
                    }
                }
            }
            // 直接break意味着我们不用考虑森林的情况
            // 如果不加break我们可以兼容多个无向图的森林的生成树
            // break;
        }
        return result;
    }

    // 请保证graph是连通图
    // graph[i][j]表示点i到点j的距离，如果是系统最大值代表无路
    // 返回值是最小连通图的路径之和
    public static int prim(int[][] graph) {
        int size = graph.length;
        int[] distances = new int[size];
        boolean[] visit = new boolean[size];
        visit[0] = true;
        for (int i = 0; i < size; i++) {
            distances[i] = graph[0][i];
        }
        int sum = 0;
        for (int i = 1; i < size; i++) {
            int minPath = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < size; j++) {
                if (!visit[j] && distances[j] < minPath) {
                    minPath = distances[j];
                    minIndex = j;
                }
            }
            if (minIndex == -1) {
                return sum;
            }
            visit[minIndex] = true;
            sum += minPath;
            for (int j = 0; j < size; j++) {
                if (!visit[j] && distances[j] > graph[minIndex][j]) {
                    distances[j] = graph[minIndex][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("hello world!");
    }

}