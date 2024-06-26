package leetcode.editor.cn;

import java.util.*;

class ID28FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new ID28FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {

            if (needle.isEmpty()) {
                return 0;
            }
            int[] next = new int[needle.length()];
            getNextNums(next, needle);

            int j = -1;

            for (int i = 0; i < haystack.length(); i++) {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                    j = next[j];
                }
                if (haystack.charAt(i) == needle.charAt(j + 1)) {
                    j++;
                }
                if (j == needle.length() - 1) {
                    return (i - needle.length() + 1);

                }
            }
            return -1;

        }

        public void getNextNums(int[] next, String s) {
            int j = -1;
            next[0] = j;
            for (int i = 1; i < s.length(); i++) {
                while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                    j = next[j];
                }

                if (s.charAt(i) == s.charAt(j + 1)) {
                    j++;
                }
                next[i] = j;

            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
