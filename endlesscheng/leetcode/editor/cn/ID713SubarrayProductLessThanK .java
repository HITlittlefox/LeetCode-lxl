package endlesscheng.leetcode.editor.cn;

class ID713SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new ID713SubarrayProductLessThanK().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        //sb.appened(solution.   );

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {

            // 需要知道的是：
            // 1. 每次 j 增加时，以 j 结尾的满足乘积小于 k 的子数组数量为 j - i + 1
            // 因为以 j 结尾的子数组可以从 i 到 j 的任意一个位置作为起点，都满足乘积小于 k。

            // 异常情况
            if (k <= 1) {
                return 0;
            }

            int n = nums.length;
            int left = 0;
            int multi = 1;
            int ans = 0;
            for (int right = 0; right < n; right++) {
                // 1. 入
                multi *= nums[right];
                // 3. 出
                while (multi >= k) {
                    multi /= nums[left];
                    left++;
                }
                // 2. 更新
                ans += right - left + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
