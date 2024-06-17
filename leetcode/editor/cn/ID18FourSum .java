package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

class ID18FourSum {
    public static void main(String[] args) {
        Solution solution = new ID18FourSum().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        //System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {

            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for (int curFirst = 0; curFirst < nums.length; curFirst++) {
                // Pruning operation
                if (nums[curFirst] > 0 && nums[curFirst] > target) {
                    return res;
                }
                // 对第1个数去重
                if (curFirst > 0 && nums[curFirst] == nums[curFirst - 1]) {
                    continue;
                }
                int threeSumTarget = target - nums[curFirst];

                // 很重要的 第二个值 在第一个值后面
                for (int curSecond = curFirst + 1; curSecond < nums.length; curSecond++) {

                    // 对第2个数去重
                    if (curSecond > curFirst + 1 && nums[curSecond] == nums[curSecond - 1]) {
                        continue;
                    }

                    int left = curSecond + 1;
                    int right = nums.length - 1;

                    while (left < right) {
                        int tempSum = nums[curSecond] + nums[left] + nums[right];
                        if (tempSum < threeSumTarget) {
                            left++;
                        } else if (tempSum > threeSumTarget) {
                            right--;
                        } else {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[curFirst]);
                            list.add(nums[curSecond]);
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

            }


            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}