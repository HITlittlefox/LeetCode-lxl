import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            } else {
                stack.add(c);
            }
        }

        Stack<Character> stackTemp = new Stack<>();
        if (stack.isEmpty())
            return "";

        while (!stack.isEmpty()) {
            stackTemp.add(stack.pop());
        }

        String result = stackTemp.isEmpty() ? "" : stackTemp.pop().toString();
        while (!stackTemp.isEmpty()) {
            result += stackTemp.pop().toString();
        }
        return result;
    }
}
// @lc code=end
