package class18;

public class Code01_RobotWalk {

    public static int robotWalkRegularRecursion(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        return process1(start, K, aim, N);
    }

    // 机器人当前来到的位置是cur，
    // 机器人还有rest步需要去走，
    // 最终的目标是aim，
    // 有哪些位置？1~N
    // 返回：机器人从cur出发，走过rest步之后，最终停在aim的方法数，是多少？
    public static int process1(int cur, int rest, int aim, int N) {
        if (rest == 0) { // 如果已经不需要走了，走完了！
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) { // 1 -> 2
            return process1(2, rest - 1, aim, N);
        }
        if (cur == N) { // N-1 <- N
            return process1(N - 1, rest - 1, aim, N);
        }
        return process1(cur - 1, rest - 1, aim, N)
                + process1(cur + 1, rest - 1, aim, N);
    }

    // 动态规划(记忆化搜索)：你的暴力递归过程有重复计算,我给你加缓存,下次遇到同样过程直接给你解
    // 如果把整个DP表从简单状态到复杂状态都列出来,就是经典的动态规划
    // dp就是缓存表
    // dp[cur][rest] == -1 -> process1(cur, rest)之前没算过！
    // dp[cur][rest] != -1 -> process1(cur, rest)之前算过！返回值，dp[cur][rest]
    // N+1 * K+1
    public static int robotWalkMemoryDP(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        return walkCache(start, K, aim, N, dp);
    }

    // cur 范: 1 ~ N
    // rest 范：0 ~ K
    public static int walkCache(int cur, int rest, int aim, int N, int[][] dp) {
        // 如果之前算过了,直接出来结果
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        // 之前没算过！
        int ans = 0;
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = walkCache(2, rest - 1, aim, N, dp);
        } else if (cur == N) {
            ans = walkCache(N - 1, rest - 1, aim, N, dp);
        } else {
            ans = walkCache(cur - 1, rest - 1, aim, N, dp) + walkCache(cur + 1, rest - 1, aim, N, dp);
        }
        dp[cur][rest] = ans;
        return ans;

    }

    public static int robotWalkDP(int start, int aim, int K, int N) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        int[][] dp = new int[N + 1][K + 1];

        // cur已经到aim，而剩余步数也为0了
        dp[aim][0] = 1;
        // 处理其他的情况
        for (int rest = 1; rest <= K; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }

        return dp[start][K];
    }

    public static void main(String[] args) {
        System.out.println(robotWalkRegularRecursion(5, 2, 4, 6));
        System.out.println(robotWalkMemoryDP(5, 2, 4, 6));
        System.out.println(robotWalkDP(5, 2, 4, 6));
    }

}
