package class14;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code_MyUnionFind {

    // 并查集结构中的节点类型
    public static class Node<V> {
        V value;

        public Node(V v) {
            value = v;
        }
    }

    public static class UnionSet<V> {
        // 记录样本到样本代表点的关系
        public HashMap<V, Node<V>> nodes;
        // 记录某节点到父亲节点的关系。
        // 比如b指向a，c指向a，d指向a，a指向自身
        // map中保存的a->a b->a c->a d->a
        public HashMap<Node<V>, Node<V>> parents;
        // 只有当前点，他是代表点，会在sizeMap中记录该代表点的连通个数
        public HashMap<Node<V>, Integer> sizeMap;

        // 初始化构造一批样本
        public UnionSet(List<V> values) {
            // 每个样本的V指向自身的代表节点
            // 每个样本当前都是独立的，parent是自身
            // 每个样本都是代表节点放入sizeMap
            for (V cur : values) {
                Node<V> node = new Node<>(cur);
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        // 优化
        // 从点cur开始，一直往上找，找到不能再往上的代表点，返回
        // 通过把路径上所有节点指向最上方的代表节点，目的是把findFather优化成O(1)的
        public Node<V> findFather(Node<V> cur) {
            // 在找father的过程中，沿途所有节点加入当前容器，便于后面扁平化处理
            Stack<Node<V>> path = new Stack<>();
            // 当前节点的父亲不是指向自己，进行循环
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }
            // 循环结束，cur是最上的代表节点
            // 把沿途所有节点拍平，都指向当前最上方的代表节点
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        // isSameSet方法
        public boolean isSameSet(V a, V b) {
            // 先检查a和b有没有登记
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            // 比较a的最上的代表点和b最上的代表点
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        // union方法
        public void union(V a, V b) {
            // 先检查a和b有没有都登记过
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }

            // 找到a的最上面的代表点
            Node<V> aHead = findFather(nodes.get(a));
            // 找到b的最上面的代表点
            Node<V> bHead = findFather(nodes.get(b));

            // 只有两个最上代表点内存地址不相同，需要union
            if (aHead != bHead) {

                // 由于aHead和bHead都是代表点，那么在sizeMap里可以拿到大小
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);

                // 哪个小，哪个挂在下面
                Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                // 把小集合直接挂到大集合的最上面的代表节点下面
                parents.put(small, big);
                // 大集合的代表节点的size要吸收掉小集合的size
                sizeMap.put(big, aSetSize + bSetSize);
                // 把小的记录删除
                sizeMap.remove(small);
            }
        }
    }

}