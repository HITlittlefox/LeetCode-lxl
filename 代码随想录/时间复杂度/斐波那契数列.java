package 代码随想录.时间复杂度;

public class 斐波那契数列 {
    public static void main(String[] args) {
        int result = fibonacci(10);
        System.out.println(result);
    }

    static int fibonacci(int i) {
        if (i <= 0) return 0;
        if (i == 1) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}
