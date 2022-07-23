package class16;

// 由于任何图都可以理解为有向图，我们定义有向的边结构
public class Edge {
    // 边的权重信息
    public int weight;
    // 出发的节点
    public Node from;
    // 指向的节点
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}