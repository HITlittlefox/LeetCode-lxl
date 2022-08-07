import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
/* 
 * 1. 因为需要记录下标,不能先sort
 * 2. hash 法
 * 利用Map构造映射，
 * 遍历 nums [i] 时，看 target-nums [i] 是否存在 hash 表中即可
 * 时间复杂度 O（n），空间复杂度 O（n）
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // 值,下标
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
// @lc code=end
