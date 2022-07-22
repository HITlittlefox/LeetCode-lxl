package 代码随想录.数组;

/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
// 思路1:二维数组,左/右/下/中
// 整体来说,逐渐向左下变成小圈
// 先处理大圈,也就是1234567
// 再处理小圈,也就是89
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowIndex = 0;

        // 每次循环的开始点 0,1
        int newStart = 0;
        int columnIndex = 0;
        // 记录循环次数
        int loopNum = 0;
        // 填充数字
        int initial = 1;

        // n=3 n/2=1 loopNum=0,1
        // && (initial <= n*n)
        while (loopNum++ <= (n / 2)) {

            // 上面第一行
            // n-loopNum = 3-0=3,需要取012 第二次:3-1=2
            // 第二轮循环的时候 columnIndex = 0 1
            for (columnIndex = newStart; columnIndex < n - loopNum; columnIndex++) {
                // 列增长
                result[newStart][columnIndex] = initial++;
            }

            // 右面第一列
            // n-loopNum = 3-0=3,需要取012 第二次:3-1=2
            // 第二轮循环的时候 columnIndex = 1
            // rowIndex = 1,
            for (rowIndex = newStart; rowIndex < n - loopNum; rowIndex++) {
                // 行增长
                result[rowIndex][columnIndex] = initial++;
            }

            // 下面第一行
            // n-loopNum = 3-0=3,需要取012 第二次:3-1=2
            for (; columnIndex >= loopNum; columnIndex--) {
                // 列减少
                result[rowIndex][columnIndex] = initial++;
            }

            // 下面第一行
            // n-loopNum = 3-0=3,需要取012 第二次:3-1=2
            for (; rowIndex >= loopNum; rowIndex--) {
                // 行减少
                result[rowIndex][columnIndex] = initial++;
            }

            newStart++;
        }

        if (n % 2 == 1) {
            result[n / 2][n / 2] = n * n;
        }

        return result;
    }
}
// @lc code=end
