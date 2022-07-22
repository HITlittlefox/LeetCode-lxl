/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start

// 哈希表26位填充 +1+1
//                -1-1
class Solution {
    public boolean isAnagram(String s, String t) {
        // 使用数组实现哈希表
        int[] record = new int[26];
        System.out.println('a' - 'b');
        for (char perChar : s.toCharArray()) {
            record[perChar - 'a'] += 1;
        }
        for (char perChar : t.toCharArray()) {
            record[perChar - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }

        }
        return true;
    }
}
// @lc code=end
