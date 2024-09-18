package endlesscheng.leetcode.editor.cn;

import java.util.Arrays;

class ID2389LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        Solution solution = new ID2389LongestSubsequenceWithLimitedSum().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        //sb.append(solution.   );

        System.out.println(sb);
    }

    /**
     * 时间复杂度 O()
     * 空间复杂度 O()
     **/

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            // 1. 计算前缀和
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1]; // 原地求前缀和
            }
            // 2. 二分求解 第一个大于 target 的数的下标 转换为
            // 可以转换为`第一个大于等于 x+1 的下标` ，low_bound(x+1)
            int[] ans = new int[queries.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = lowBound(nums, queries[i]);
            }
            return ans;
        }


        public int lowBound(int[] nums, int target) {
            int left = -1, right = nums.length;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                // 此处必须是 < 或者 >=
                if (nums[mid] < target) {
                    left = mid; // (mid, right)
                } else {
                    right = mid;// (left, mid)
                }
            }
            return right;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
