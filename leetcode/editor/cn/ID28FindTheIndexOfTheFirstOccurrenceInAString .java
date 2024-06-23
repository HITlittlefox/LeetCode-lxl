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

            int i = 0;
            int j = 0;

            while (i < haystack.length()) {
                int i2 = i;
                int j2 = 0;
                while (haystack.charAt(i2) == needle.charAt(j2)) {
                    i2++;
                    j2++;
                    if (i2 == haystack.length() && j2 != needle.length()) {
                        return -1;
                    }
                    if (j2 == needle.length()) {
                        return i;
                    }
                }
                i++;
            }
            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
