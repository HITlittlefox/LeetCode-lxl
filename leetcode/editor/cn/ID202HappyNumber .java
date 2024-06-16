package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

class ID202HappyNumber {
    public static void main(String[] args) {
        Solution solution = new ID202HappyNumber().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> rec = new HashSet<>();
            while (n != 1 && !rec.contains(n)) {
                rec.add(n);
                n = getNextNumber(n);
            }

            if (n == 1) {
                return true;
            } else {
                return false;
            }
        }

        public int getNextNumber(int n) {
            int res = 0;
            while (n > 0) {
                int temp = n % 10;
                res += temp * temp;
                n = n / 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}