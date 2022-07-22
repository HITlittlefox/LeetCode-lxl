import java.util.Stack;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
// 1. 空格问题(左/右/中间多于一个的空格减为一个)
// 2. 字符串从头到尾翻转
// 3. 记录单词,直到遇到一次空格,把记录内容翻转.继续.
class Solution {
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stackHelp = new Stack<>();

        for (char perChar : s.toCharArray()) {
            if (stack.empty() && perChar == ' ') {
                continue;
            }
            if (!stack.empty() && stack.peek() == ' ' && perChar == ' ') {
                continue;
            }
            // System.out.println("11");
            // TODO:这里没有处理最后一个空格(最后的空格不会多余一个)
            stack.add(perChar);

        }
        System.out.println("完成for循环");

        // 处理最后一个空格
        if (!stack.empty() && stack.peek() == ' ') {
            stack.pop();
        }
        System.out.println("完成处理最后一个空格");

        // 得到了1,2完成
        String result = "";
        while (!stack.empty()) {
            if (stack.peek() == ' ') {
                stack.pop();
                continue;
            }
            while (stack.peek() != ' ') {
                stackHelp.add(stack.pop());
                if (stack.empty() || stack.peek() == ' ') {
                    break;
                }
            }
            // System.out.println("完成处第一轮的空格前入栈");
            while (!stackHelp.empty()) {
                result += stackHelp.pop();
                // System.out.println(result);
            }
            
            if (stack.empty()) {
                return result;
            } else {
                result += " ";
                continue;
            }
            // System.out.println(result.length());
        }
        return result;
    }
}
// @lc code=end

// 1.
// eulb -- stack--blue
// eulb si yks eht
//
// 2.
// blue