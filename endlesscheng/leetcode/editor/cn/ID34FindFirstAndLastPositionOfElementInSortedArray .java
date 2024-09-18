package endlesscheng.leetcode.editor.cn;

class ID34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new ID34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        //sb.append(solution.   );

        System.out.println(sb);
    }

    /**
     * 时间复杂度 O(log n)
     * 空间复杂度 O(1)
     **/

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            // 递增
            // 要算两个数，一个是该元素的第一个位置，也就是>=该元素的第一个下标
            // 要算两个数，二个是该元素的最后一个位置，也就是<=该元素的最后一个下标

            int start = lowBound(nums, target);

            if (start == nums.length || nums[start] != target) {
                return new int[]{-1, -1};
            }

            // <=该元素的最后一个下标 是 >= (该元素+1) 的第一个下标 的左边一个位置
            int end = lowBound3(nums, target + 1) - 1;
            return new int[]{start, end};
        }

        // [left, right]
        public int lowBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            // left与right错位了，才是终止条件
            // 区间不为空
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1; // [mid+1, right]
                } else {
                    right = mid - 1;// [left, mid-1]
                }
            }
            return left; // right + 1
        }

        // [left, right)
        public int lowBound2(int[] nums, int target) {
            int left = 0, right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1; // [mid+1, right)
                } else {
                    right = mid;// [left, mid)
                }
            }
            return left; // right
        }

        // (left, right)
        public int lowBound3(int[] nums, int target) {
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
            return right; // left + 1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
