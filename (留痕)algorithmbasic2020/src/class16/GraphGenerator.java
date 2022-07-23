package class16;

public class GraphGenerator {

    // matrix 所有的边
    // N*3 的矩阵
    // [weight, from节点上面的值，to节点上面的值]
    //
    // [ 5 , 0 , 7]
    // [ 3 , 0,  1]
    //

    // matrix 所有的边
    // N*3 的矩阵
    // [weight, from节点上面的值，to节点上面的值]
    public static Graph createGraph(Integer[][] matrix) {
        // 定义我们的图结构
        Graph graph = new Graph();
        // 遍历给定的图结构进行转换
        for (int i = 0; i < matrix.length; i++) {
            // matrix[0][0], matrix[0][1]  matrix[0][2]
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];

            // 我们的图结构不包含当前from节点，新建该节点
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            // 没有to节点，建立该节点
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            // 拿出我们图结构的from节点
            Node fromNode = graph.nodes.get(from);
            // 拿出我们图结构的to节点
            Node toNode = graph.nodes.get(to);
            // 建立我们的边结构。权重，from指向to
            Edge newEdge = new Edge(weight, fromNode, toNode);
            // 把to节点加入到from节点的直接邻居中
            fromNode.nexts.add(toNode);
            // from的出度加1
            fromNode.out++;
            // to的入度加1
            toNode.in++;
            // 该边需要放到from的直接边的集合中
            fromNode.edges.add(newEdge);
            // 把该边加入到我们图结构的边集中
            graph.edges.add(newEdge);
        }
        return graph;
    }

}