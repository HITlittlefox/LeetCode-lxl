package class16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

// no negative weight
// 没改进之前的版本
public class Code06_Dijkstra {


    // 返回的map表就是从from到表中每个key的最小距离
    // 某个点不在map中记录，则from到该点位正无穷
    public static HashMap<Node, Integer> dijkstra1(Node from) {

        // 从from出发到所有点的最小距离表
        HashMap<Node, Integer> distanceMap = new HashMap<>();

        // from到from距离为0
        distanceMap.put(from, 0);

        // 已经求过距离的节点，存在selectedNodes中，以后再也不碰
        HashSet<Node> selectedNodes = new HashSet<>();

        // from 0 得到没选择过的点中的最小距离
        Node minNode =
                getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);

        // 得到minNode之后
        while (minNode != null) {

            // 把minNode对应的距离取出,此时minNode就是桥连点 就是 原点---桥连点 的距离
            int distance = distanceMap.get(minNode);

            // 把minNode上所有的邻边拿出来
            // 这里就是要拿到例如A到C和A到桥连点B再到C哪个距离小的距离
            for (Edge edge : minNode.edges) {
                // 某条边对应的下一跳节点toNode
                Node toNode = edge.to;

                // 如果关于from的distencMap中没有去toNode的记录，表示正无穷，直接添加该条
                if (!distanceMap.containsKey(toNode)) {
                    // 如果没有，直接添加
                    // from到minNode的距离 加上 minNode到当前to节点的边距离
                    distanceMap.put(toNode, distance + edge.weight);

                    // 如果有，看该距离是否更小，更小就更新
                } else {
                    // 老的距离，取代，新的距离
                    distanceMap.put(edge.to,
                            Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            // 锁上minNode，表示from通过minNode到其他节点的最小值已经找到
            // minNode将不再使用
            selectedNodes.add(minNode);
            // 再在没有选择的节点中挑选MinNode当成from的桥接点
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        // 最终distanceMap全部更新，返回
        return distanceMap;
    }


    // 得到没选择过的点的最小距离
    public static Node getMinDistanceAndUnselectedNode(
            HashMap<Node, Integer> distanceMap,
            HashSet<Node> touchedNodes) {

        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        // 遍历该表，确保没有被选过，并且距离最小
        for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            // 没有被选择过，且距离最小
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        // 抓出来这个点，返回
        return minNode;
    }

    //====================================================================
    //====================================================================
    //====================================================================

    /**
     * 我们可以借助小根堆来替代之前的distanceMap。达到优化算法的目的
     * 原因是之前我们要遍历hash表选出最小距离，现在直接是堆顶元素
     * 但是我们找到通过桥节点更小的距离后，需要临时更该堆结构中元素数据
     * 所以系统提供的堆我们需要改写
     **/

    public static class NodeRecord {
        // 当前节点
        public Node node;
        // 源节点到当前节点的最小距离是什么
        public int distance;

        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // 自定义小根堆结构
    // 需要提供add元素的方法，和update元素的方法
    // 需要提供ignore方法，表示我们已经找到from到某节点的最短路径
    // 再出现from到该节点的其他路径距离，我们直接忽略
    public static class NodeHeap {
        private Node[] nodes; // 实际的堆结构
        // key 某一个node， value 上面堆中的位置
        // 如果节点曾经进过堆，现在不在堆上，则node对应-1
        // 用来找需要ignore的节点
        private HashMap<Node, Integer> heapIndexMap;
        // key 某一个节点， value 从源节点出发到该节点的目前最小距离
        private HashMap<Node, Integer> distanceMap;
        private int size; // 堆上有多少个点

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            size = 0;
        }

        // 该堆是否空
        public boolean isEmpty() {
            return size == 0;
        }

        // 有一个点叫node，现在发现了一个从源节点出发到达node的距离为distance
        // 判断要不要更新，如果需要的话，就更新
        public void addOrUpdateOrIgnore(Node node, int distance) {
            // 如果该节点在堆上，就看是否需要更新
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                // 该节点进堆，判断是否需要调整
                insertHeapify(node, heapIndexMap.get(node));
            }
            // 如果没有进入过堆。新建，进堆
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node, size++);
            }
            // 如果不在堆上，且进来过堆上，什么也不做，ignore
        }

        // 弹出from到堆顶节点的元素，获取到该元素的最小距离，再调整堆结构
        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            // 把最后一个元素放在堆顶，进行heapify
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);
            // free C++同学还要把原本堆顶节点析构，对java同学不必
            nodes[size - 1] = null;
            heapify(0, --size);
            return nodeRecord;
        }

        private void insertHeapify(Node node, int index) {
            while (distanceMap.get(nodes[index])
                    < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
                        ? left + 1
                        : left;
                smallest = distanceMap.get(nodes[smallest])
                        < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        // 判断node是否进来过堆
        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        // 判断某个节点是否在堆上
        private boolean inHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }
    }

    // 使用自定义小根堆，改进后的dijkstra算法
    // 从from出发，所有from能到达的节点，生成到达每个节点的最小路径记录并返回
    public static HashMap<Node, Integer> dijkstra2(Node from, int size) {
        // 申请堆
        NodeHeap nodeHeap = new NodeHeap(size);
        // 在堆上添加from节点到from节点距离为0
        nodeHeap.addOrUpdateOrIgnore(from, 0);
        // 最终的结果集
        HashMap<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            // 每次在小根堆弹出堆顶元素
            NodeRecord record = nodeHeap.pop();
            // 拿出的节点
            Node cur = record.node;
            // from到该节点的距离
            int distance = record.distance;
            // 以此为桥接点，找是否有更小的距离到该节点的其他to节点
            // addOrUpdateOrIgnore该方法保证
            // 如果from到to的节点没有，就add
            // 如果有,看是否需要Ignore，如果不需要Ignore且更小，就Update
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }

}