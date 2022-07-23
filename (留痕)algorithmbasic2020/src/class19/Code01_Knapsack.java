package class19;

//
//public class Code01_Knapsack {
//
//    // 所有的货，重量和价值，都在w和v数组里
//    // 为了方便，其中没有负数
//    // bag背包容量，不能超过这个载重
//    // 返回：不超重的情况下，能够得到的最大价值
//    public static int maxValue(int[] w, int[] v, int bag) {
//        if (w == null || v == null || w.length != v.length || w.length == 0) {
//            return 0;
//        }
//        // 尝试函数！
//        return process(w, v, 0, bag);
//    }
//
//    // index 0~N
//    // rest 负~bag
//    public static int process(int[] w, int[] v, int index, int rest) {
//        if (rest < 0) {
//            return -1;
//        }
//        if (index == w.length) {
//            return 0;
//        }
//        int p1 = process(w, v, index + 1, rest);
//        int p2 = 0;
//        int next = process(w, v, index + 1, rest - w[index]);
//        if (next != -1) {
//            p2 = v[index] + next;
//        }
//        return Math.max(p1, p2);
//    }
//
//    public static int dp(int[] w, int[] v, int bag) {
//        if (w == null || v == null || w.length != v.length || w.length == 0) {
//            return 0;
//        }
//        int N = w.length;
//        int[][] dp = new int[N + 1][bag + 1];
//        for (int index = N - 1; index >= 0; index--) {
//            for (int rest = 0; rest <= bag; rest++) {
//                int p1 = dp[index + 1][rest];
//                int p2 = 0;
//                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
//                if (next != -1) {
//                    p2 = v[index] + next;
//                }
//                dp[index][rest] = Math.max(p1, p2);
//            }
//        }
//        return dp[0][bag];
//    }
//
//    public static void main(String[] args) {
//        int[] weights = {3, 2, 4, 7, 3, 1, 7};
//        int[] values = {5, 6, 3, 19, 12, 4, 2};
//        int bag = 15;
//        System.out.println(maxValue(weights, values, bag));
//        System.out.println(dp(weights, values, bag));
//    }
//
//}
public class Code01_Knapsack {

    public static int getMaxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, 0, bag);
    }

    // 第一种尝试
    // 不变 ： w[] 重量数组  v[] 价值数组  bag 袋子的总载重
    // index... 最大价值
    // 0..index-1上做了货物的选择，使得你已经达到的重量是多少 alreadyW
    // 如果返回-1，认为没有方案
    // 如果不返回-1，认为返回的值是真实价值
    public static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        // base case
        if (alreadyW > bag) {
            return -1;
        }
        // 重量没超
        if (index == w.length) {
            return 0;
        }

        // 当前不选择index的货物情况下，后续的价值
        // 无需传递当前index的重量，且p1就是总价值
        int p1 = process(w, v, index + 1, alreadyW, bag);

        // 当前选择了index的货物，把重量加上，继续向下递归
        int p2next = process(w, v, index + 1, alreadyW + w[index], bag);

        // p2表示要了当前货物之后总价值应该是后续价值加上当前价值
        int p2 = -1;
        if (p2next != -1) {
            p2 = v[index] + p2next;
        }
        return Math.max(p1, p2);

    }

    public static int maxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, bag);
    }

    // 第二种尝试。更经典
    // 只剩下rest的空间了，
    // index...货物自由选择，但是剩余空间不要小于0
    // 返回 index...货物能够获得的最大价值
    public static int process(int[] w, int[] v, int index, int rest) {
        // base case 1 无效方案
        if (rest < 0) {
            return -1;
        }
        // rest >=0。index来到终止位置，当前返回0价值
        // base case 2
        if (index == w.length) {
            return 0;
        }

        // 有货也有空间。
        // 当前index不选择，得到p1总价值
        int p1 = process(w, v, index + 1, rest);
        int p2 = -1;

        // 选择了index位置，剩余空间减去当前重量
        int p2Next = process(w, v, index + 1, rest - w[index]);

        // 如果递归到了不错的数(即p2!=-1了)，
        // 选择index的总价值，是index...的价值加上个当前index的价值
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    public static int dpWay(int[] w, int[] v, int bag) {
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 1; rest <= bag; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest >= w[index]) {
                    dp[index][rest] = Math.max(dp[index][rest], v[index] + dp[index + 1][rest - w[index]]);
                }
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dpWay(weights, values, bag));
    }

}