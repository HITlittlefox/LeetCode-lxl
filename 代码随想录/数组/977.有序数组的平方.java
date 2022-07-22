package 代码随想录.数组;

/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
/*
// 思路1:常规方法,先绝对值,排序,再挨个平方
class Solution {
    public int[] sortedSquares(int[] nums) {
        // 正数
        for (int i = 0; i <= nums.length - 1; i++) {
            nums[i] = (nums[i] >= 0) ? nums[i] : -1 * nums[i];
            System.out.println(nums[i]);
        }

        // 排序
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        // // // 奇数可以
        // int pre = 0;
        // int last = nums.length - 1;
        // int[] result = new int[nums.length];
        // int mid = (pre + last) / 2;

        // result[0] = nums[mid];
        // for (int j = 1; j <= mid; j++) {
        // if (nums[mid - j] < nums[mid + j]) {
        // result[2 * j - 1] = nums[mid - j];
        // result[2 * j] = nums[mid + j];
        // } else {
        // result[2 * j - 1] = nums[mid + j];
        // result[2 * j] = nums[mid - j];
        // }
        // }

        // 平方
        for (int k = 0; k <= nums.length - 1; k++) {
            // System.out.println(k);
            nums[k] = nums[k] * nums[k];
        }
        return nums;

    }
} */

// 思路二:双指针:直接将双指针分别初始化在 nums 的开头和结尾，相当于合并两个从大到小排序的数组，和 88 题类似。
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        // 两个指针分别初始化在正负子数组绝对值最大的元素索引
        int i = 0, j = n - 1;
        // 得到的有序结果是降序的
        int p = n - 1;
        int[] res = new int[n];
        // 执行双指针合并有序数组的逻辑
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[p] = nums[i] * nums[i];
                i++;
            } else {
                res[p] = nums[j] * nums[j];
                j--;
            }
            p--;
        }
        return res;
    }
}
// @lc code=end
