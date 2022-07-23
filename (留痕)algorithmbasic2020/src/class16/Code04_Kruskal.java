package class16;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

//undirected graph only
public class Code04_Kruskal {

    // Union-Find Set
    public static class UnionFind {
        // key 某一个节点， value key节点往上的节点
        private HashMap<Node, Node> fatherMap;
        // key 某一个集合的代表节点, value key所在集合的节点个数
        private HashMap<Node, Integer> sizeMap;

        public UnionFind() {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findFather(Node n) {
            Stack<Node> path = new Stack<>();
            while (n != fatherMap.get(n)) {
                path.add(n);
                n = fatherMap.get(n);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), n);
            }
            return n;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aDai = findFather(a);
            Node bDai = findFather(b);
            if (aDai != bDai) {
                int aSetSize = sizeMap.get(aDai);
                int bSetSize = sizeMap.get(bDai);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aDai, bDai);
                    sizeMap.put(bDai, aSetSize + bSetSize);
                    sizeMap.remove(aDai);
                } else {
                    fatherMap.put(bDai, aDai);
                    sizeMap.put(aDai, aSetSize + bSetSize);
                    sizeMap.remove(bDai);
                }
            }
        }
    }


    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }

    }


    // K算法
    public static Set<Edge> kruskalMST(Graph graph) {
        // 先拿到并查集结构
        UnionFind unionFind = new UnionFind();
        // 该图的所有点加入到并查集结构
        unionFind.makeSets(graph.nodes.values());
        // 边按照权值从小到大**排序**，加入到小根堆
        PriorityQueue<Edge> priorityQueue =
                new PriorityQueue<>(new EdgeComparator());

        for (Edge edge : graph.edges) { // M 条边
            priorityQueue.add(edge);  // O(logM)
        }

        Set<Edge> result = new HashSet<>();
        // 堆不为空，弹出小根堆的堆顶
        while (!priorityQueue.isEmpty()) {
            // 假设M条边，O(logM)
            Edge edge = priorityQueue.poll();

            // 如果该边的左右两侧不在同一个集合中
            if (!unionFind.isSameSet(edge.from, edge.to)) { // O(1)
                // 要这条边
                result.add(edge);
                // 联合from和to
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
