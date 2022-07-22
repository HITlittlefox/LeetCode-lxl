import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        // i left right
        List<List<Integer>> result = new ArrayList<>();
        int leftNum;
        int rightNum;
        for (int i = 0; i < nums.length; i++) {
            // 第一层防重复:排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }
            // 第二层防重复:i遇到重复就跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            leftNum = i + 1;
            rightNum = nums.length - 1;
            while (rightNum > leftNum) {
                int sum = nums[i] + nums[leftNum] + nums[rightNum];
                if (sum > 0) {
                    rightNum--;
                    if (rightNum == i) {
                        continue;
                    }
                    if (rightNum == leftNum) {
                        break;
                    }
                } else if (sum < 0) {
                    leftNum++;

                    if (leftNum == i) {
                        continue;
                    }
                    if (leftNum == rightNum) {
                        break;
                    }
                } else if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[leftNum], nums[rightNum]));

                    // 第三层防重复:如果leftNum或者rightNum有相同数,直接跳过
                    while (rightNum > leftNum && nums[rightNum] == nums[rightNum - 1]) {
                        rightNum--;
                    }
                    while (rightNum > leftNum && nums[leftNum] == nums[leftNum + 1]) {
                        leftNum++;
                    }
                    rightNum--;
                    leftNum++;
                }

                // int left = nums[leftNum];
                // int right = nums[rightNum];

            }
            // for (List<Integer> list : result) {
            // Arrays.sort(list);
            // }

        }
        return result;
    }
}
// @lc code=end
