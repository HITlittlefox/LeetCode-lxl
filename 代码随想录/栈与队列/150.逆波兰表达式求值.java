import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int tempPre = 0;
        int tempLast = 0;
        int temp = 0;

        // String[] tokens2 = tokens;

        for (String string : tokens) {
            System.out.println(string);
            // if (!stack.isEmpty()) {
            if (string.equals("+")) {
                tempLast = Integer.valueOf(stack.pop());
                tempPre = Integer.valueOf(stack.pop());
                temp = tempPre + tempLast;
                stack.add(String.valueOf(temp));
                System.out.println(temp);
                continue;
            }
            if (string.equals("-")) {
                tempLast = Integer.valueOf(stack.pop());
                tempPre = Integer.valueOf(stack.pop());
                temp = tempPre - tempLast;
                stack.add(String.valueOf(temp));
                continue;
            }
            if (string.equals("*")) {
                tempLast = Integer.valueOf(stack.pop());
                tempPre = Integer.valueOf(stack.pop());
                temp = tempPre * tempLast;
                stack.add(String.valueOf(temp));
                continue;
            }
            if (string.equals("/")) {
                tempLast = Integer.valueOf(stack.pop());
                tempPre = Integer.valueOf(stack.pop());
                temp = tempPre / tempLast;
                stack.add(String.valueOf(temp));
                continue;
            }
            stack.add(string);
            // }
        }
        int result = 0;
        result = stack.isEmpty() ? 0 : Integer.valueOf(stack.peek());
        return result;
    }
}
// @lc code=end
