package class16;

import java.util.ArrayList;

// 点结构的描述  A  0
public class Node {
    // 点的编号，标识
    public int value;
    // 入度，表示有多少个点连向该点
    public int in;
    // 出度，表示从该点出发连向别的节点多少
    public int out;
    // 直接邻居：表示由自己出发，直接指向哪些节点。nexts.size==out
    public ArrayList<Node> nexts;
    // 直接下级边：表示由自己出发的边有多少
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}