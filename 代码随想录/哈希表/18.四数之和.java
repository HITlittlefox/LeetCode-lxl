import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start

// 首先能想到的,就是把他们简化为三数之和,AB先全排列凑出target集合,再按刚才的双指针方法挨个找数据.
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length < 4)
            return ans;

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int l = j + 1, r = nums.length - 1;
                while (l < r) {

                    Long sum = nums[i] * 1l + nums[j] + nums[l] + nums[r];// 注意要用long，否则相加后会溢出，由于相加时底层是用临时变量存储中间值得，因此一个数乘1L，临时变量的类型会默认为long类型

                    int left = nums[l], right = nums[r];
                    if (sum < target) {
                        while (l < r && nums[l] == left) {// 去重
                            l++;
                        }
                    } else if (sum > target) {
                        while (l < r && nums[r] == right) {// 去重
                            r--;
                        }
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == left)
                            l++;
                        while (l < r && nums[r] == right)
                            r--;
                    }
                }
            }
        }

        return ans;
    }
}
// @lc code=end
