package endlesscheng.leetcode.editor.cn;

class ID162FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new ID162FindPeakElement().new Solution();
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
        public int findPeakElement(int[] nums) {

            int left = 0, right = nums.length - 1;
            // 此处不可以是 <= ，否则会进入死循环！！！
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return right;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
