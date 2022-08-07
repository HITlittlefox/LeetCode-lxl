package 二分;
/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
// 暴力
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }
        // 起点：左下角
        int x = rows - 1;
        int y = 0;
        // 不越界的条件是：行大于等于 0，列小于等于 cols - 1
        while (x >= 0 && y < cols) {
            // 打开注释，可以用于调试的代码
            // System.out.println("沿途走过的数字：" + matrix[x][y]);
            if (matrix[x][y] > target) {
                x--;
            } else if (matrix[x][y] < target) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }
}

// @lc code=end
