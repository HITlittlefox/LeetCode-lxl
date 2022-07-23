package class12;

public class Code04_IsFull {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 第一种方法
    // 收集整棵树的高度h，和节点数n
    // 只有满二叉树满足 : 2 ^ h - 1 == n
    public static boolean isFull1(Node head) {
        if (head == null) {
            return true;
        }
        Info1 all = process1(head);
        return (1 << all.height) - 1 == all.nodes;
    }

    public static class Info1 {
        // 以x为头节点的树的高度
        public int height;
        // 以x为头节点的树的节点数
        public int nodes;

        public Info1(int h, int n) {
            height = h;
            nodes = n;
        }
    }

    // 递归主程序
    public static Info1 process1(Node head) {
        if (head == null) {
            return new Info1(0, 0);
        }
        // 往左递归
        // 往右递归
        Info1 leftInfo = process1(head.left);
        Info1 rightInfo = process1(head.right);
        // 要信息：height
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 要信息：nodes
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;

        return new Info1(height, nodes);
    }

    // 第二种方法
    // 收集子树是否是满二叉树
    // 收集子树的高度
    // 左树满 && 右树满 && 左右树高度一样 -> 整棵树是满的
    public static boolean isFull2(Node head) {
        if (head == null) {
            return true;
        }
        return process2(head).isFull;
    }

    public static class Info2 {
        public boolean isFull;
        public int height;

        public Info2(boolean f, int h) {
            // 收集子树是否是满二叉树
            isFull = f;
            // 收集子树的高度
            height = h;

        }
    }

    // 递归主程序
    public static Info2 process2(Node h) {
        if (h == null) {
            return new Info2(true, 0);
        }
        // 左树
        Info2 leftInfo = process2(h.left);
        // 右树
        Info2 rightInfo = process2(h.right);
        // 是否满
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        // 高度
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info2(isFull, height);
    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
/*			if (isFull1(head) != isFull2(head)) {
				System.out.println("出错了!");
			}*/
            if (isFull1(head) != isFull1(head)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }

}
