package endlesscheng.leetcode.editor.cn;

import java.util.HashMap;

class ID3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new ID3LongestSubstringWithoutRepeatingCharacters().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        sb.append(solution.lengthOfLongestSubstring("pwwkew"));

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            // 时间复杂度 O(n)
            // 空间复杂度 O(1)

            int ans = Integer.MIN_VALUE;
            int left = 0;
            // 用hashmap存储出现过的重复字符的个数
            HashMap<Character, Integer> map = new HashMap<>();
            for (int right = 0; right < s.length(); right++) {
                // 1. 入
                char cRight = s.charAt(right);
                // 跳过重复的：删除上一个重复的，用新的重复的作为起点
                if (!map.containsKey(cRight)) {
                    map.put(cRight, 1);
                } else {
                    map.put(cRight, map.get(cRight) + 1);
                    while (map.get(cRight) > 1) {
                        // 3. 从头开始出
                        // 此处应该从left头开始降低value，而不是从right开始！！！
                        char cLeft = s.charAt(left);
                        System.out.println("map.get(cLeft) = " + map.get(cLeft));
                        map.put(cLeft, map.get(cLeft) - 1);
                        left += 1;
                    }
                    if (map.get(cRight) == 0) {
                        map.remove(cRight);
                    }
                }

                // 2. 更新
                ans = Math.max(ans, right - left + 1);
            }

            return ans == Integer.MIN_VALUE ? 0 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
