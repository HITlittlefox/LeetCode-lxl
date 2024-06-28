package leetcode.editor.cn;

import java.util.*;

class ID27RemoveElement {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {

            //将数组分成「前后」两段
            int j = nums.length - 1;
            for (int i = 0; i <= j; i++) {
                if (nums[i] == val) {
                    swapTwoVal(nums, i, j);
                    i--;
                    j--;
                }
            }
            return j + 1;
        }

        public void swapTwoVal(int[] nums, int index1, int index2) {
            int temp = nums[index2];
            nums[index2] = nums[index1];
            nums[index1] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
