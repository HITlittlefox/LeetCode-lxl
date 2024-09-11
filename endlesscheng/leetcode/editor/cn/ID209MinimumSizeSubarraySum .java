package endlesscheng.leetcode.editor.cn;

class ID209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new ID209MinimumSizeSubarraySum().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        sb.append(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            // 时间复杂度：O(n)
            // 空间复杂度：O(1)

            int n = nums.length;
            int sum = 0;
            // 计算长度用
            int left = 0;
            int minLen = Integer.MAX_VALUE;
            for (int right = 0; right < n; right++) {
                // 1. 入
                sum += nums[right];
                System.out.println("sum = " + sum);
                while (sum >= target) {
                    //2. 更新
                    minLen = Math.min(minLen, right - left + 1);
                    System.out.println("minLen = " + minLen);
                    // 3. 出
                    sum -= nums[left];
                    left++;
                }
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
