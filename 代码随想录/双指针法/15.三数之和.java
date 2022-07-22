import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
// 定i,左指针pre是i右边第一个,右指针last是末尾
class Solution {
    // 定义三个指针，保证遍历数组中的每一个结果
    // 画图，解答
    public List<List<Integer>> threeSum(int[] nums) {
        // 定义一个结果集
        List<List<Integer>> result = new ArrayList<>();
        // 从小到大排序
        Arrays.sort(nums);
        int pre = 0;
        int last = nums.length - 1;
        int sum = 0;
        // 左指针挨个指
        for (int i = 0; i < nums.length - 1; i++) {
            // 排好序后,如果大于0,就不用看了
            if (nums[i] > 0) {
                return result;
            }
            // 如果i这个位置重复,直接跳过
            if (i >= 1 && nums[i - 1] == nums[i]) {
                continue;
            }
            pre = i + 1;
            last = nums.length - 1;
            sum = 0;
            while (pre < last) {
                // 三个数的和
                sum = nums[i] + nums[pre] + nums[last];
                if (sum == 0) {
                    // 如果==0,加入
                    result.add(Arrays.asList(nums[i], nums[pre], nums[last]));
                    // 因为已经加过了,pre这个位置再重复就不行了
                    while (pre < last && nums[pre] == nums[pre + 1]) {
                        pre++;
                    } // 到达最后一个相同的pre
                      // 因为已经加过了,last这个位置再重复就不行了
                    while (pre < last && nums[last] == nums[last - 1]) {
                        last--;
                    } // 到达最后一个相同的last
                    pre++;
                    last--;
                }
                if (sum < 0) {
                    pre++;
                }
                if (sum > 0) {
                    last--;
                }

            }
        }
        return result;
    }
}

// @lc code=end
