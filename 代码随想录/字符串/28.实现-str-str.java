/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
// 双指针
/* class Solution {
    public int strStr(String haystack, String needle) {
        // System.out.println(haystack.charAt(1));
        int aim = 0;
        int cur = 0;
        int result = -1;
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            aim = i;
            result = i;
            // 剩余长度不足,直接返回-1
            if (haystack.length() - aim < needle.length()) {
                return -1;

            }
            while (haystack.charAt(aim) == needle.charAt(cur)) {
                aim++;
                cur++;
                if (cur == needle.length()) {
                    return result;
                }
            }
            cur = 0;

        }
        return -1;
    }
} */

class Solution {
    // 前缀表（不减一）Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);// 已经获得next数组

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 前后缀不同的情况
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            // 前后缀相同的情况
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;

    }

    private void getNext(int[] next, String s) {
        // j 前缀数组
        int j = 0;
        next[0] = 0;
        // i 从第二个数开始
        // i 后缀数组
        for (int i = 1; i < s.length(); i++) {
            // 前后缀不同的情况
            // while回退
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                // 反向
                j = next[j - 1];
            }
            // 前后缀相同的情况
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            } // 反正吧,从这个if出来,他就是到了最大相等前后缀了
            next[i] = j;
        }
        for (int i : next) {
            System.out.println(i);
        }
    }
}
/*
 * class Solution {
 * public int strStr(String haystack, String needle) {
 * // 两种特殊情况
 * if (needle.length() == 0) {
 * return 0;
 * }
 * if (haystack.length() == 0) {
 * return -1;
 * }
 * // char 数组
 * char[] hasyarr = haystack.toCharArray();
 * char[] nearr = needle.toCharArray();
 * // 长度
 * int halen = hasyarr.length;
 * int nelen = nearr.length;
 * // 返回下标
 * return kmp(hasyarr, halen, nearr, nelen);
 * 
 * }
 * 
 * public int kmp(char[] hasyarr, int halen, char[] nearr, int nelen) {
 * // 获取next 数组
 * int[] next = next(nearr, nelen);
 * int j = 0;
 * for (int i = 0; i < halen; ++i) {
 * // 发现不匹配的字符，然后根据 next 数组移动指针，移动到最大公共前后缀的，
 * // 前缀的后一位,和咱们移动模式串的含义相同
 * while (j > 0 && hasyarr[i] != nearr[j]) {
 * j = next[j - 1] + 1;
 * // 超出长度时，可以直接返回不存在
 * if (nelen - j + i > halen) {
 * return -1;
 * }
 * }
 * // 如果相同就将指针同时后移一下，比较下个字符
 * if (hasyarr[i] == nearr[j]) {
 * ++j;
 * }
 * // 遍历完整个模式串，返回模式串的起点下标
 * if (j == nelen) {
 * return i - nelen + 1;
 * }
 * }
 * return -1;
 * }
 * 
 * // 这一块比较难懂，不想看的同学可以忽略，了解大致含义即可，或者自己调试一下，看看运行情况
 * // 我会每一步都写上注释
 * public int[] next(char[] needle, int len) {
 * // 定义 next 数组
 * int[] next = new int[len];
 * // 初始化
 * next[0] = -1;
 * int k = -1;
 * for (int i = 1; i < len; ++i) {
 * // 我们此时知道了 [0,i-1]的最长前后缀，但是k+1的指向的值和i不相同时，我们则需要回溯
 * // 因为 next[k]就时用来记录子串的最长公共前后缀的尾坐标（即长度）
 * // 就要找 k+1前一个元素在next数组里的值,即next[k+1]
 * while (k != -1 && needle[k + 1] != needle[i]) {
 * k = next[k];
 * }
 * // 相同情况，就是 k的下一位，和 i 相同时，此时我们已经知道 [0,i-1]的最长前后缀
 * // 然后 k - 1 又和 i 相同，最长前后缀加1，即可
 * if (needle[k + 1] == needle[i]) {
 * ++k;
 * }
 * next[i] = k;
 * 
 * }
 * return next;
 * }
 * }
 */
// @lc code=end
