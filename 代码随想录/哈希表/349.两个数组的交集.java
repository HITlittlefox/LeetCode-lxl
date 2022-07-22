import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
// 两个数组,存每个字母词频
// 都不为空的,存入第三个数组,也就是交集
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (Integer integer : nums1) {
            set1.add(integer);
        }
        for (Integer integer : nums2) {
            if (set1.contains(integer)) {
                resSet.add(integer);
            }
        }

        int[] arr = new int[resSet.size()];
        int index = 0;
        // 将结果集合转为数组
        for (int i : resSet) {
            arr[index++] = i;
        }

        return arr;
    }
}
// @lc code=end
