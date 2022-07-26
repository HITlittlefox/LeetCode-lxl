import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12)
            return res; // 算是剪枝了
        backtracking(s, 0, 0);
        return res;
    }

    // 递归参数
    // startIndex: 搜索的起始位置，pointNum:添加逗点的数量
    // 用逗号的数量来指示分界了几个
    void backtracking(String s, int startIndex, int pointNum) {
        // 递归终止条件
        if (pointNum == 3) {
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)) {
                res.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                // 在str的后⾯插⼊⼀个逗点
                s = s.substring(0, i + 1) +
                        "." +
                        s.substring(i + 1);
                System.out.println(s);
                pointNum++;
                backtracking(s, i + 2, pointNum);
                // 回溯删掉逗点
                s = s.substring(0, i + 1) +
                        s.substring(i + 2);
                pointNum--;
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        // 遇到⾮数字字符不合法
        for (int i = start; i <= end; i++) {
            // 比较的是ASCII码
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            // 如果⼤于255了不合法
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
