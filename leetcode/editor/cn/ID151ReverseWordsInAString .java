package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 不要使用辅助空间，空间复杂度要求为O(1)。
 * 先整体反转
 * 再每个单词原地反转
 */
class ID151ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ID151ReverseWordsInAString().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 不使用Java内置方法实现
         * <p>
         * 1.去除首尾以及中间多余空格
         * 2.反转整个字符串
         * 3.反转各个单词
         */
        public String reverseWords(String s) {
            // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
            // 1.去除首尾以及中间多余空格
            StringBuilder sb = removeSpace(s);
            // 2.反转整个字符串
            reverseString(sb, 0, sb.length() - 1);
            // 3.反转各个单词
            reverseEachWord(sb);
            return sb.toString();
        }

        private StringBuilder removeSpace(String s) {
            // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
            int start = 0;
            int end = s.length() - 1;
            // 开头的空格
            while (s.charAt(start) == ' ') start++;

            // 末尾的空格
            while (s.charAt(end) == ' ') end--;

            // 单词之间的大于1的空格
            StringBuilder sb = new StringBuilder();
            while (start <= end) {
                char c = s.charAt(start);
                // 即将要添加的字符非空， 或者 即将添加的是空&&已经添加的字符最后一个不是空
                if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(c);
                }
                start++;
            }
            // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
            return sb;
        }

        /**
         * 反转字符串指定区间[start, end]的字符
         */
        public void reverseString(StringBuilder sb, int start, int end) {
            // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
            while (start < end) {
                char temp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);
                start++;
                end--;
            }
            // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
        }

        private void reverseEachWord(StringBuilder sb) {
            int i = 0;
            int j = 1;
            int size = sb.length();

            while (i < size) {
                while (j < size && sb.charAt(j) != ' ') {
                    j++;
                }

                // j 此时是空格
                reverseString(sb, i, j - 1);
                i = j + 1;
                j = i + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
