package endlesscheng.leetcode.editor.cn;

import java.util.List;

class ID2856MinimumArrayLengthAfterPairRemovals {
    public static void main(String[] args) {
        Solution solution = new ID2856MinimumArrayLengthAfterPairRemovals().new Solution();
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
        public int minLengthAfterRemovals(List<Integer> nums) {

            // 解析后的四种情况：
            // [1,2,3,4,5,5,5,6] maxCnt=3 n=8
            // [1,2,3,4,5,5,5,5] maxCnt=3 n=8
            // [1,2,3,4,4,5,5,5] maxCnt=3 n=8
            // [1,1,1,4,4,5,5,5] maxCnt=3 n=8 1145 45 15

            // 1. 如果 maxCnt⋅2>n，其余所有 n−maxCnt 个数都要与 x 消除，所以最后剩下 maxCnt⋅2−n 个数。
            // 2. 如果 maxCnt⋅2≤n 且 n 是偶数，那么可以把其余数消除至剩下 maxCnt 个数，然后再和 x 消除，最后剩下 0 个数。
            // 3. 如果 maxCnt⋅2≤n 且 n 是奇数，同上，最后剩下 1 个数。

            int n = nums.size();
            // 无需排序
            int x = nums.get(n / 2);
            // >=x的角标， >=x+1 的角标-1  众数个数为：后-前+1
            int maxCnt = lowerBound(nums, x + 1) - 1 - lowerBound(nums, x) + 1;
            return Math.max(maxCnt * 2 - n, n % 2);

        }

        public int lowerBound(List<Integer> nums, int target) {
            int left = -1, right = nums.size();
            while (left + 1 < right) {
                // 防止溢出 >>是右移运算符，右移一位相当于除2，右移n位相当于除以2的n次方；
                int mid = left + ((right - left) >> 1);
                if (nums.get(mid) < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
