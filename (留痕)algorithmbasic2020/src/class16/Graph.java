package class16;

import java.util.HashMap;
import java.util.HashSet;


// 图结构
public class Graph {
    // 点的集合，编号为1的点是什么，用map
    public HashMap<Integer, Node> nodes;
    // 边的集合
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
