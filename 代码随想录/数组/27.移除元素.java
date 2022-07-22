package 代码随想录.数组;

/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
/*
// 思路: val冒泡 
class Solution {
    
    // 先找出整个数组中第一个val的下标,
    // 然后目标是让数组中全部val都到后面几位
    // 当遇到第一个val,开始让val冒泡,每一个循环能让一个val冒泡到最后
    // 哪怕最坏的情况,也可以让val都冒泡后面去
    public int removeElement(int[] nums, int val) {
        int ResultLength = 0;
        int valFirstNum = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == val) {
                valFirstNum = k;
                break;
            }
        }
        for (int i = valFirstNum; i < nums.length; i++) {
            valPop(nums, val);
        }
        for (int j : nums) {
            if (j != val) {
                ResultLength++;
            }
        }
        return ResultLength;
    }

    public static void valPop(int[] nums, int val) {
        int temp;
        // val冒泡
        for (int i = 0; i + 1 <= nums.length - 1; i++) {
            if (nums[i] == val) {
                temp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = temp;
            }
        }
    }
} */

/*
// 暴力递归
class Solution {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            // 发现需要移除的元素，就将数组集体向前移动一位
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                i--;
                // 此时数组的大小-1
                size--;
            }
        }
        return size;
    }
}
*/


// 双指针法:通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。
// 快指针:寻找新数组的元素 ，新数组就是不含有目标元素的数组
// 慢指针:指向更新 新数组下标的位置
class Solution {
    public int removeElement(int[] nums, int val) {

        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;

    }
}

// @lc code=end
