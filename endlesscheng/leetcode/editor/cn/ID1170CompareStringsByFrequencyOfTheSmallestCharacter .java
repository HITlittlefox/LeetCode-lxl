package endlesscheng.leetcode.editor.cn;

import java.util.Arrays;

class ID1170CompareStringsByFrequencyOfTheSmallestCharacter {
    public static void main(String[] args) {
        Solution solution = new ID1170CompareStringsByFrequencyOfTheSmallestCharacter().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        sb.append(solution.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"}));

        //sb.append(solution.numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"}));

        System.out.println(sb);
    }

    /**
     * 时间复杂度 O()
     * 空间复杂度 O()
     **/

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            // 思路：
            // 1排序 2找到最小字母，查询第一个>=该字母的 x  ~ 第一个>=该字母+1 的y，得出该字母的个数 y-x

            // 新思路：1排序 2找到最小字母，n - 第一个>=该字母+1 的y - 1，得出该字母的个数 n-y

            // 针对queries 算出 对应的f()
            // 针对words 算出 对应的f()


            int[] queriesNums = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                char[] s = queries[i].toCharArray();
                Arrays.sort(s);
                char minChar = s[0];
                // 此处应该是+1 ，而不是+'1'
                queriesNums[i] = lowBound(s, (char) (minChar + 1)) - 1 - lowBound(s, minChar);
            }

            int[] wordsNums = new int[words.length];
            for (int i = 0; i < wordsNums.length; i++) {
                char[] s = words[i].toCharArray();
                Arrays.sort(s);
                char minChar = s[0];
                wordsNums[i] = lowBound(s, (char) (minChar + 1)) - 1 - lowBound(s, minChar);
            }

            int[] ans = new int[queries.length];
            for (int i = 0; i < ans.length; i++) {
                int tempAns = 0;
                for (int j = 0; j < wordsNums.length; j++) {
                    if (wordsNums[j] > queriesNums[i]) {
                        tempAns++;
                    }
                }
                ans[i] = tempAns;
            }
            return ans;

        }

        public int lowBound(char[] nums, char target) {
            int left = -1, right = nums.length;
            while (left + 1 < right) {
                int middle = left + (right - left) / 2;
                // 此处必须是 < 或者 >=
                if (nums[middle] < target) {
                    left = middle; // (mid, right)
                } else {
                    right = middle;// (left, mid)
                }
            }
            // 需要能指出 >= target的位置
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
