/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
/* class Solution {
    public String reverseStr(String s, int k) {

        // 重点在n-x*2k,也就是最后一个无法满足2k的区间
        // 每2k翻转前k个
        int n = s.length();

        // 主要分为两块,
        // 第一块 n-n%2k,也就是都满足2k数量的,分别翻转即可
        // 起始位置:0
        // 终止位置:n/(2*k)*2*k-1
        char[] sTemp = s.toCharArray();
        char temp;

        if (n <= k) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                temp = sTemp[left];
                sTemp[left] = sTemp[right];
                sTemp[right] = temp;
                left++;
                right--;
            }
        }

        //
        if (n < 2 * k && n > k) {
            int left = 0;
            int right = k - 1;
            while (left < right) {
                temp = sTemp[left];
                sTemp[left] = sTemp[right];
                sTemp[right] = temp;
                left++;
                right--;
            }
        }
        if (n >= 2 * k) {
            // if (n - n % (2 * k) == 0) {
            for (int i = 0; i <= (n / (2 * k)) * 2 * k - 1; i += 2 * k) {
                // int left = s.toCharArray()[i];
                // int right = s.toCharArray()[(i + i + 2 * k - 1) / 2];
                int left = i;
                int right = (i + i + 2 * k - 1) / 2;
                while (left < right) {
                    temp = sTemp[left];
                    sTemp[left] = sTemp[right];
                    sTemp[right] = temp;
                    left++;
                    right--;
                }
            }
        }
        // }
        // System.out.println(String.valueOf(sTemp));
        // return s;

        // 第二块,n%2k,再分情况,是n%2k<k,还是k<n%2k<2k
        // if (n - n % (2 * k) == 0) {
        // if (n >= 2 * k) {

        if ((n / (2 * k)) >= 1 && n % (2 * k) < k) {

            int left = (n / (2 * k)) * 2 * k - 1 + 1;
            int right = n - 1;
            while (left < right) {
                temp = sTemp[left];
                sTemp[left] = sTemp[right];
                sTemp[right] = temp;
                left++;
                right--;
            }

        }

        if ((n / (2 * k)) >= 1 && n % (2 * k) >= k) {
            // for (int i = 0; i <= (n / (2 * k)) * 2 * k - 1; i += 4) {
            // // int left = s.toCharArray()[i];
            // // int right = s.toCharArray()[(i + i + 2 * k - 1) / 2];

            int left = (n / (2 * k)) * 2 * k - 1 + 1;
            int right = (n / (2 * k)) * 2 * k - 1 + k;
            while (left < right) {
                temp = sTemp[left];
                sTemp[left] = sTemp[right];
                sTemp[right] = temp;
                left++;
                right--;
            }
            // }
            // }
        }
        s = String.valueOf(sTemp);
        System.out.println(String.valueOf(sTemp));
        return s;
    }

}
 */

//解法二（似乎更容易理解点）
//题目的意思其实概括为 每隔2k个反转前k个，尾数不够k个时候全部反转
class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        // for (int i = 0; i < ch.length; i += 2 * k) {
        // int start = i;
        // // 这里是判断尾数够不够k个来取决end指针的位置
        // int end = Math.min(ch.length - 1, start + k - 1);
        // // 用异或运算反转
        // while (start < end) {
        // ch[start] ^= ch[end];
        // ch[end] ^= ch[start];
        // ch[start] ^= ch[end];
        // start++;
        // end--;
        // }
        // }

        for (int i = 0; i < ch.length; i += 2 * k) {
            int left = i;
            int right = Math.min(ch.length - 1, left + k - 1);

            while (left < right) {
                ch[left] ^= ch[right];
                ch[right] ^= ch[left];
                ch[left] ^= ch[right];
                left++;
                right--;
            }
        }

        return new String(ch);
    }
}
// @lc code=end
