/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
// 双指针
/* class Solution {
    public void reverseString(char[] s) {
        int j = s.length - 1;
        int mid = (0 + j) / 2;
        for (int i = 0; i <= mid; i++) {
            swap(s, i, j);
            j--;
        }
    }

    void swap(char[] s, int start, int end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        return;
    }
} */

// 递归
class Solution {
    char temp = 0;
    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);

    }

    public void reverse(char[]s, int left, int right) {
        // 返回条件
        if (left>=right) {
            return;
        }

        // 递之前
        temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // 递下去
        reverse(s, left+1, right-1);

        // 归回来
        // Do nothing.

    }
}
// @lc code=end
