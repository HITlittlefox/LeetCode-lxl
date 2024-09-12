package endlesscheng.leetcode.editor.cn;

class ID153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new ID153FindMinimumInRotatedSortedArray().new Solution();
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
        public int findMin(int[] nums) {

            // nums[mid] 与最后一个数比较大小
            // 最后一个数：最小值或者最小值右侧
            // 总结：小于最后一个数，就是蓝色，否则是红色
            int left = 0, right = nums.length - 1;
            int endI = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[endI]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 停下时是left == right 了
            return nums[right];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
