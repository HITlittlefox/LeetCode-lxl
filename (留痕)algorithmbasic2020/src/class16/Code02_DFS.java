package class16;

import java.util.HashSet;
import java.util.Stack;

public class Code02_DFS {

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        // Set的作用和宽度优先遍历类似，保证重复的点不要进栈
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        // 打印实时机是在进栈的时候
        // 同理该步可以换成其他处理逻辑，表示深度遍历处理某件事情
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            // 枚举当前弹出节点的后代
            for (Node next : cur.nexts) {
                // 只要某个后代没进入过栈，进栈
                if (!set.contains(next)) {
                    // 把该节点的父亲节点重新压回栈中
                    stack.push(cur);
                    // 再把自己压入栈中
                    stack.push(next);
                    set.add(next);
                    // 打印当前节点的值
                    System.out.println(next.value);
                    // 直接break，此时栈顶是当前next节点，达到深度优先的目的
                    break;
                }
            }
        }
    }

}