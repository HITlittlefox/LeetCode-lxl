package class17;

import java.util.Stack;

public class Code05_ReverseStackUsingRecursive {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // i是栈底元素，f调整之后的栈成为去掉栈底元素后的栈
        int i = f(stack);
        // 递归调用
        reverse(stack);
        // 经过base case之后，栈为空，此时压入的就是当前的栈底
        stack.push(i);
    }

    // 栈底元素移除掉
    // 上面的元素盖下来
    // 返回移除掉的栈底元素
    public static int f(Stack<Integer> stack) {
        // 弹出栈顶，用result临时变量记住这个栈顶元素
        int result = stack.pop();
        // 如果栈为空，向上返回弹出的result，此时result就是栈底元素
        if (stack.isEmpty()) {
            return result;
        } else {
            // 此时栈不为空，让子问题给我一个临时变量，临时变量就是子问题base case返回的result
            int last = f(stack);
            // 把我弹出的result再压入栈，向上返回子问题给我的result
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

    }

}