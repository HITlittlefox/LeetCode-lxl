import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
// 小饼干先喂饱小胃口
class Solution {
    int result = 0;

    public int findContentChildren(int[] g, int[] s) {
        int childIndex = 0;
        Arrays.sort(g);// 胃口
        Arrays.sort(s);// 饼干

        for (int i = 0; i < s.length && childIndex < g.length; i++) {

            if (s[i] >= g[childIndex]) {
                result++;
                System.out.println("result:" + result);
                childIndex++;

            }
        }
        return result;
    }
}
// @lc code=end
