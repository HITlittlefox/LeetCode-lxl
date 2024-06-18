package leetcode.editor.cn;

import java.util.*;

class ID344ReverseString {
    public static void main(String[] args) {
        Solution solution = new ID344ReverseString().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 本地置换
         *
         * @param s
         */
        public void reverseStringV2(char[] s) {
            if (s.length <= 1) {
                return;
            }

            int head = 0;
            int tail = s.length - 1;

            while (head < tail) {
                char temp = s[tail];
                s[tail] = s[head];
                s[head] = temp;

                head++;
                tail--;
            }
            return;
        }

        /**
         * 位运算交换
         *
         * @param s
         */
        public void reverseString(char[] s) {
            if (s.length <= 1) {
                return;
            }

            int head = 0;
            int tail = s.length - 1;

            while (head < tail) {
                // 异或位运算原地取值
                s[head] ^= s[tail];
                s[tail] ^= s[head];
                s[head] ^= s[tail];

                head++;
                tail--;
            }
            return;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
