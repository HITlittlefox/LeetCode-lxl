/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        // 初始化最大回文子串的起点和终点
        int start = 0;
        int end = 0;

        // 遍历每个位置，当做中心位
        for (int i = 0; i < s.length(); i++) {
            // 分别拿到奇数偶数的回文子串长度
            int len_odd = expandCenter(s, i, i);
            int len_even = expandCenter(s, i, i + 1);
            // 对比最大的长度
            int len = Math.max(len_odd, len_even);
            // 计算对应最大回文子串的起点和终点
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        // 注意：这里的end+1是因为 java自带的左闭右开的原因
        return s.substring(start, end + 1);
    }

    /**
     *
     * @param s     输入的字符串
     * @param left  起始的左边界
     * @param right 起始的右边界
     * @return 回文串的长度
     */
    private int expandCenter(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 回文串的长度是right-left+1-2 = right - left - 1
        return right - left - 1;
    }
}
// @lc code=end
