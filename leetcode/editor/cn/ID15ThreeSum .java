package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

class ID15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ID15ThreeSum().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        //System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for (int cur = 0; cur < nums.length; cur++) {
                if (nums[cur] > 0) {
                    return res;
                }

                // 对第一个数去重：不能有重复的三元组，但三元组内的元素是可以重复的
                if (cur > 0 && nums[cur] == nums[cur - 1]) {
                    continue;
                }

                int left = cur + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int tempSum = nums[cur] + nums[left] + nums[right];
                    if (tempSum < 0) {
                        left++;
                    } else if (tempSum > 0) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[cur]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);

                        // 三元组内数字 去重
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    }
                }


            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}