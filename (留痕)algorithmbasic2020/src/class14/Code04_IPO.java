package class14;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code04_IPO {

    // 最多K个项目
    // W是初始资金
    // Profits[] Capital[] 一定等长
    // 返回最终最大的资金
    public static int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital) {
        // 由花费组织的小根堆（锁住的boss）
        PriorityQueue<Program> minCostQ = new PriorityQueue<>(new MinCostComparator());
        // 由利润组织的大根堆（解锁的boss）
        PriorityQueue<Program> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());

        // 把所有项目加入到由花费组织的小根堆里
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Program(Profits[i], Capital[i]));
        }
        // 做k轮项目
        for (int i = 0; i < K; i++) {
            // 小根堆不为空，且堆顶的花费被我当前启动资金cover住
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                // 小根堆的堆顶 扔到 大根堆中去
                maxProfitQ.add(minCostQ.poll());
            }
            // 经历了解锁过程，但是大根堆没有可以做的项目，直接返回所有钱数
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            // 大根堆不为空，堆顶元素的利润直接加到我们的总钱数上
            // 大根堆弹出堆顶元素
            W += maxProfitQ.poll().p;
        }
        return W;
    }

    // 项目实体类
    public static class Program {
        public int p;
        public int c;

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    // 根据花费组织的小根堆的比较器
    public static class MinCostComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.c - o2.c;
        }

    }

    // 根据利润组织的大根堆的比较器
    public static class MaxProfitComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o2.p - o1.p;
        }

    }

}
