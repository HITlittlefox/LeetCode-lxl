/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
// * 1.去除首尾以及中间多余空格
// * 2.反转整个字符串
// * 3.反转各个单词
class Solution {
    public String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s +
        // "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        // 开头不能是空格
        while (s.charAt(start) == ' ')
            start++;
        // 结尾不能是空格
        while (s.charAt(end) == ' ')
            end--;
        StringBuilder sb = new StringBuilder();
        // 从前往后开干
        while (start <= end) {
            char c = s.charAt(start);
            // 允许正常数下来,允许第一个空格下来,第二个空格就不行了
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    private void reverseString(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    // 以空格为分界线,找到每个单词,进行翻转
    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;

        }
    }

}
// @lc code=end
