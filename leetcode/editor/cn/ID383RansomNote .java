package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

class ID383RansomNote {
    public static void main(String[] args) {
        Solution solution = new ID383RansomNote().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        //System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {

            // array better than map

            if (ransomNote.length() > magazine.length()) {
                return false;
            }

            int[] rec = new int[26];
            for (char i : magazine.toCharArray()) {
                rec[i - 'a'] += 1;
            }

            for (char i : ransomNote.toCharArray()) {
                rec[i - 'a'] -= 1;
            }

            for (int i : rec) {
                if (i < 0) {
                    return false;
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}