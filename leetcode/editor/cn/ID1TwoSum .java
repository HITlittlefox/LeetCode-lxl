package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

class ID1TwoSum {
    public static void main(String[] args) {
        Solution solution = new ID1TwoSum().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        //System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {

            int[] resArr = new int[2];
            if (nums == null || nums.length == 0) {
                return resArr;
            }

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    if (map.get(target - nums[i]) != i) {
                        resArr[0] = i;
                        resArr[1] = map.get(target - nums[i]);
                        return resArr;
                    }
                }
            }
            return resArr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}