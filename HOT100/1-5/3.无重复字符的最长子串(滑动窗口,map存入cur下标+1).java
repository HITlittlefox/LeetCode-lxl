import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
/**
 * map (k, v)，其中 key 值为字符，value 值为字符位置+1;
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char cur = s.charAt(end);
            // 包含
            if (map.keySet().contains(cur)) {
                start = Math.max(map.get(cur), start);
            }
            res = Math.max(res, end - start + 1);
            map.put(cur, end + 1);
        }
        return res;
    }
}
// @lc code=end
