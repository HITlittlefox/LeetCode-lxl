import java.util.Stack;

/*
* @lc app=leetcode.cn id=20 lang=java
*
* [20] 有效的括号
*/

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                left.push(rightOf(c));
            } else if (!left.isEmpty() && c == left.peek()) {
                left.pop();
            } else {
                return false;
            }

        }
        return left.isEmpty();
    }

    public char rightOf(char c) {
        if (c == '{')
            return '}';
        if (c == '(')
            return ')';
        return ']';

    }
}
// @lc code=end
