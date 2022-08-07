package 二分;

/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        int mid = (l + r) / 2;
        // 本就是有序数组
        if (numbers[r] > numbers[l])
            return numbers[l];

        while (l <= r) {
            // 如果二分后的数组是有序数组，则返回最左元素，即为最小
            if (numbers[r] > numbers[l])
                return numbers[l];
            // 若最左小于mid元素，则最左到mid是严格递增的，那么最小元素必定在mid之后
            if (numbers[l] < numbers[mid]) {
                l = mid + 1;
                mid = (l + r) / 2;
            }
            // 若最左大于mid元素，则最小元素必定在最左到mid之间(不包括最左，因为最左已经大于mid)
            else if (numbers[l] > numbers[mid]) {
                r = mid;
                l++;
                mid = (l + r) / 2;
            }
            // 若二者相等，则最小元素必定在l+1到r之间，因为l和mid相等，故可以去除
            else {
                l++;
                mid = (l + r) / 2;
            }
        }
        return numbers[mid];
    }
}

// @lc code=end
