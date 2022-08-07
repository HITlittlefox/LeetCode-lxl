import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
// 大饼干先喂饱大胃口
class Solution {
    int result = 0;

    public int findContentChildren(int[] g, int[] s) {
        int childIndex = g.length - 1;
        Arrays.sort(g);// 胃口
        Arrays.sort(s);// 饼干

        for (int i = 0; i < Math.min(s.length, g.length); i++) {
            if (childIndex < 0) {
                return result;
            }
            if (s[s.length - 1 - i] >= g[childIndex]) {
                result++;
                childIndex--;
            } else {
                i--;// 饼干保持不动,找更小胃口的孩子
                childIndex--;
            }
        }
        return result;
    }
}
// @lc code=end
