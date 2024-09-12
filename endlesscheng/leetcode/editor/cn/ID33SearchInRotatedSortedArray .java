package endlesscheng.leetcode.editor.cn;

class ID33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new ID33SearchInRotatedSortedArray().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        //sb.append(solution.   );

        System.out.println(sb);
    }

    /**
     * 时间复杂度：O(logn)，其中 n 为 nums 的长度。
     * 空间复杂度：O(1)，仅用到若干额外变量
     **/

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {

            int left = 0, right = nums.length - 1;
            // 左闭右闭
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isBlue(nums, target, mid)) {
                    right = mid - 1; //  [left, mid - 1]
                } else {
                    left = mid + 1; // [mid+1, right]
                }
            }
            return nums[left] == target ? left : -1;

        }

        private boolean isBlue(int[] nums, int target, int i) {
            int x = nums[i];
            if (x > nums[nums.length - 1]) {
                return target > nums[nums.length - 1] && x >= target;
            } else {
                return target > nums[nums.length - 1] || x >= target;

            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
