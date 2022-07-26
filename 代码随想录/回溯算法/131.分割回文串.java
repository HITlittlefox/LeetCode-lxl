import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {

        backtracking(s, 0);
        return res;
    }

    void backtracking(String s, int startIndex) {
        // 如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            // res.add(path);
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                // 获取[startIndex,i]在s中的子串
                String str = s.substring(startIndex, i + 1);
                path.add(str);
            } else { // 如果不是则直接跳过
                continue;
            }
            // 起始位置后移，保证不重复
            // 寻找i+1为起始位置的子串
            backtracking(s, i + 1);
            path.remove(path.size() - 1); // 回溯过程，弹出本次已经填在的子串
        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {

        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

// @lc code=end
