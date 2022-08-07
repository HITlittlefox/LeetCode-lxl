import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        // System.out.println();
        Set<Integer> record = new HashSet<>();
        String input = String.valueOf(n);
        // System.out.println(input);

        return inputStrOutStr(input, record);
    }

    public boolean inputStrOutStr(String str, Set<Integer> record) {
        // boolean flag = false;
        int out = 0;
        String outStr = null;
        for (char perChar : str.toCharArray()) {
            out += (perChar - '0') * (perChar - '0');

        }
        if (out == 1) {
            // flag = ;
            return true;

        }
        outStr = String.valueOf(out);
        if (record.contains(out)) {
            return false;
        } else {
            // if (out % 10 == 0) {
            // // flag = ;
            // return true;

            // }
            record.add(out);
            return inputStrOutStr(outStr, record);
        }

    }
}
// @lc code=end
