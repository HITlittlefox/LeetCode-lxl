package endlesscheng.leetcode.editor.cn;

class ID35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new ID35SearchInsertPosition().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        //sb.append(solution.   );

        System.out.println(sb);
    }

    /**
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     **/

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {

            // 二分法找到该目标值or找不到该目标，应该按顺序插入的位置 = 第一个大于等于x的下标
            return lowBound(nums, target);

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
            return right + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
