/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
// 拷贝覆盖
/* class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i : nums) {
            if (i != val) {
                nums[count++] = i;
            }
        }
        return count;
    }

} */

// 前后交换
class Solution {
    public int removeElement(int[] nums, int val) {
        // int i = 0;
        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {
            if (nums[i] == val) {
                swap(nums, i, j);
                i--;
                j--;
            }
        }
        return j + 1;

    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// @lc code=end
