import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return nums;
        
        // 双向队列 
        // 保存当前窗口最大值的数组位置 
        // 保证队列中数组位置的数值按从大到小排序

        // 队列中,保存的是,数组下标,而不是数
        // queue 左头右尾,递减队列
        // queue.poll--------------queue.pollast
        LinkedList<Integer> queue = new LinkedList<>();
        
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        
        
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 
            // 如果前面数小则需要依次弹出，直至满足要求
            // 面对一个大数,把前面的数都弹出,再把这个大数塞入
            while (!queue.isEmpty() && 
            nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            } // 执行了这个while之后,就是空队列了
            
            // 添加当前值对应的数组下标
            queue.addLast(i);

            // 判断当前队列中队首的值是否有效
            // 窗口在滑动,把前面的东西都扔掉
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }
}

/* class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= k) {
            int result[] = new int[1];
            int tempMax = Integer.MIN_VALUE;
            for (int i : nums) {
                tempMax = i > tempMax ? i : tempMax;
            }
            result[0] = tempMax;
            return result;
        }
        if (k == 1) {
            int result[] = new int[nums.length];
            int count = 0;
            for (int i : nums) {
                result[count++] = i;
            }
            return result;
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        int[] result = new int[nums.length - (k - 1)];
        int resultNum = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
            pushS2H(stack, help);
            stack.add(nums[i]);
            if (i >= k - 1) {
                pushH2S(stack, help, k);// 此时stack中放的就是滑动窗口
                result[resultNum] = biggestOfStack(stack);
                resultNum++;
            }
        }

        return result;
    }

    public void pushS2H(Stack<Integer> stack, Stack<Integer> help) {
        // help = new Stack<>();
        while (!stack.empty()) {
            help.add(stack.pop());
        }
        // System.out.print("pushS2H结束");
        return;
    }

    public void pushH2S(Stack<Integer> stack, Stack<Integer> help, int k) {
        // stack = new Stack<>();

        for (int i = 0; i < k - 1; i++) {
            if (help.empty()) {
                break;
            } else {
                // System.out.println(help.peek());
                stack.add(help.pop());
            }
        }
        // System.out.print("pushH2S结束");
        return;
    }

    public int biggestOfStack(Stack<Integer> stack) {
        int tempMax = Integer.MIN_VALUE;
        for (Integer integer : stack) {
            tempMax = integer > tempMax ? integer : tempMax;
        }
        return tempMax;
    }
} */
// @lc code=end
