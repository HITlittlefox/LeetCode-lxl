package 代码随想录.时间复杂度;

public class 递归算法 {
    public static void main(String[] args) {
        int result = function4(2, 3);
        System.out.println("时间复杂度是O(logN)");
        System.out.println(result);
    }

    static int function4(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int t = function4(x, n / 2);// 这里相对于function3，是把这个递归操作抽取出来
        if (n % 2 == 1) {
            return t * t * x;
        }
        return t * t;
    }
}
