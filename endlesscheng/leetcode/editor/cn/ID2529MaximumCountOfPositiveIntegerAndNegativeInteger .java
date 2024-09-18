package endlesscheng.leetcode.editor.cn;

class ID2529MaximumCountOfPositiveIntegerAndNegativeInteger {
    public static void main(String[] args) {
        Solution solution = new ID2529MaximumCountOfPositiveIntegerAndNegativeInteger().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        sb.append(solution.maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}));

        System.out.println(sb);
    }

    /**
     * 时间复杂度 O()
     * 空间复杂度 O()
     **/

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumCount(int[] nums) {
            // 转化问题为，
            // 负整数个数 = ( 最后一个小于等于x的下标：可以转换为`第一个大于等于 x+1 的下标` 的 `左边位置`, low_bound(x+1) - 1; ) + 1
            int fuZhengShuNum = lowBound(nums, -1 + 1) - 1 + 1;
            // 正整数个数 = n - ( 找到 >= 1 的数字的下标 )
            int zhengZhengShuNum = nums.length - lowBound(nums, 1);


            return Math.max(zhengZhengShuNum, fuZhengShuNum);
        }

        public int lowBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
