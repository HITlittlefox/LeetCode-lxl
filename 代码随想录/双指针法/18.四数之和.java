import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 定义一个结果集
        List<List<Integer>> result = new ArrayList<>();
        // 从小到大排序
        Arrays.sort(nums);
        int pre = 0;
        int last = nums.length - 1;
        long sum = 0;
        for (int x = 0; x < nums.length - 3; x++) {
            // 如果x这个位置重复,直接跳过
            if (x > 0 && nums[x - 1] == nums[x]) {
                continue;
            }

            // 左指针挨个指
            for (int i = x + 1; i < nums.length - 2; i++) {
                // 如果i这个位置重复,直接跳过
                // 不能是i>=i+1
                if (i > x + 1 && nums[i - 1] == nums[i]) {
                    continue;
                }

                pre = i + 1;
                last = nums.length - 1;
                while (pre < last) {
                    // 三个数的和
                    // 注意要用long，否则相加后会溢出，由于相加时底层是用临时变量存储中间值得，因此一个数乘1L，临时变量的类型会默认为long类型
                    sum = nums[x] * 1l + nums[i] + nums[pre] + nums[last];
                    if (sum == target) {
                        // 如果==0,加入
                        result.add(Arrays.asList(nums[x], nums[i], nums[pre], nums[last]));
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
                    if (sum < target) {
                        pre++;
                    }
                    if (sum > target) {
                        last--;
                    }

                }
            }
        }
        return result;
    }
}

// @lc code=end
