import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();

    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        pushIn2Out(stackIn, stackOut);
        return stackOut.pop();
    }

    public int peek() {
        pushIn2Out(stackIn, stackOut);
        return stackOut.peek();

    }

    public boolean empty() {
        if (stackIn.isEmpty() == true && stackOut.isEmpty() == true) {
            return true;
        }
        return false;

    }

    public void pushIn2Out(Stack<Integer> stackIn, Stack<Integer> stackOut) {
        // stackOut里面有东西,不用进行pushIn2Out
        if (!stackOut.isEmpty())
            return;
        while (stackIn.isEmpty() != true) {
            stackOut.push(stackIn.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
