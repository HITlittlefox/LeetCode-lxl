package leetcode.editor.cn;

import java.util.*;

class ID541ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ID541ReverseStringIi().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] input = s.toCharArray();
            char[] res = new char[s.length()];

            if (s.isEmpty()) {
                return s;
            }

            if (s.length() < k) {
//                for (int i = s.length() - 1; i >= 0; i--) {
//                    res[s.length() - 1 - i] = s.toCharArray()[i];
//                }
                reverse(input, 0, 0 + input.length - 1);
                return new String(input);
            }
            for (int i = 0; i < input.length; i += 2 * k) {

                if (i + k <= input.length) {
                    reverse(input, i, i + k - 1);
                } else {
                    reverse(input, i, input.length - 1);
                }
            }
            return new String(input);
        }


        /**
         * 定义翻转函数，反转ch[i] 到 ch[j]
         *
         * @param ch
         * @param i
         * @param j
         */
        public void reverse(char[] ch, int i, int j) {
            for (; i < j; i++, j--) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}