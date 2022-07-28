import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {

    // 符合条件的某个棋盘布局（路径）
    private List<String> path = new LinkedList<>();

    // 符合条件的所有棋盘布局的集合
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 新建字符棋盘，相比操作字符串，更方便
        char[][] board = new char[n][n];
        // 初始化棋盘
        for (int i = 0; i < board.length; ++i) {
            Arrays.fill(board[i], '.');
        }

        // 从 row=0 第一行开始遍历
        backtracking(n, 0, board);
        return res;
    }

    private void backtracking(int n, int row, char[][] board) {
        // 结束条件：所有行都遍历完成，注意是n不是n-1
        if (row == n) {
            path = array2List(board);
            res.add(path);
            return;
        }

        // 遍历选择列表，这里的一个选择就是 row+col
        for (int col = 0; col < n; ++col) {
            if (!isValid(n, row, col, board)) {
                // 排除不合法的选择（皇后存在冲突）
                continue;
            }

            // 做选择
            board[row][col] = 'Q';
            // 递归调用，进入下一行的决策
            backtracking(n, row + 1, board);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    /**
     * 将符合条件的某个棋盘数组转换成字符串列表
     * array2List 函数用来将满足题目条件的某个棋盘数组 board 转换成 List<String>，
     * 其中，棋盘数组每一行会转换成一个String，所有行转换成String后，会存放到一个 List 中
     */
    private List<String> array2List(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            ans.add(String.valueOf(board[i]));
        }
        return ans;
    }

    /**
     * 判断是否可以在当前棋盘 board[row][col] 这个位置放置皇后Q
     * n是棋盘的大小，避免重复计算，所以作为参数传入
     * 当前位置同一行所有位置中不存在皇后 Q，由于在某次遍历中，row 是不变的，也即是固定的，因此，同一行不需要判断
     * 当前位置同一列正上方所有位置中不存在皇后Q
     * 当前位置左上角对角线的所有位置中不存在皇后Q
     * 当前位置右上角对角线的所有位置不存在皇后Q
     */
    private boolean isValid(int n, int row, int col, char[][] board) {
        // 检查board[row][col]这个位置所在这一列正上方中，看是否已经存在 Q，存在说明列存在冲突，不能再放置皇后Q
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查board[row][col]这个位置左上方对角线是否已经存在皇后，左下方不用检查，因为backtracking函数是一行一行遍历的，下方的还没遍历到呢
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查board[row][col]这个位置右上方对角线是否已经存在皇后，右下方不用检查，因为
        // backtracking函数是一行一行遍历的，下方的还没遍历到呢
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
