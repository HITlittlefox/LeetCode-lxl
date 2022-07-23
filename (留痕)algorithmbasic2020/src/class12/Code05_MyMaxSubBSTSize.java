package class12;

public class Code05_MyMaxSubBSTSize {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 任何子树都需要返回的信息
    public static class Info {
        public boolean isAllBST;// 整体是否是搜索二叉树
        public int maxSubBSTSize;// 最大二叉搜索子树的大小
        public int max;// 整棵树的最大值
        public int min;// 整棵树的最小值

        public Info(boolean is, int size, int ma, int mi) {
            isAllBST = is;
            maxSubBSTSize = size;
            max = ma;
            min = mi;
        }
    }

    public static Info process1(Node head) {
        // 空树上的最大值和最小值不好设置
        // 所以返回空的话，后面用到这个信息的时候就要先判空
        if (head == null) {
            return null;
        }
        Info leftInfo = process1(head.left);// 假设左树可以返回四个信息
        Info rightInfo = process1(head.right);// 假设右树可以返回四个信息
        // head结点的值在整棵树上，需要参与决策整棵树上的最大值和最小值
        int max = head.value;
        int min = head.value;
        // 左树不为空的话，左树上的最大值可以参与决策整棵树上的最大值
        // 同理，左树上的最小值也可以参与决策整棵树上的最小值，右树上也这么干
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }
        // 第一种可能性：与head节点无关，要找的最大二叉搜索子树不以head为头结点
        // 所以这中情况下，左树和右树上的信息都能用
        int maxSubBSTSize = 0;// 先默认整颗树的最大二叉搜索子树大小为0
        if (leftInfo != null) {// 左树不为空的话，左树的答案就是目前的答案
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {// 右树不为空的话，当前答案和右树上的答案取最大值
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }
        // 第二种可能性，先假设不成立
        boolean isAllBST = false;
        // 如果可能性2成立，就设置两个变量
        // maxSubBSTSize=以head为头的所有结点数
        // isAllBST=true
        // 因为可能性2成立的话，整棵树就是二叉搜索树

        // 左树为空左树必是搜索二叉树，不为空的话，拿左树上的信息来用，右树同理
        // 左树为空并不影响二叉搜索树的性质，为空则拿左树的信息来用，右树同理
        if (
                (leftInfo == null ? true : leftInfo.isAllBST)
                        &&
                        (rightInfo == null ? true : rightInfo.isAllBST)
                        &&
                        (leftInfo == null ? true : leftInfo.max < head.value)
                        &&
                        (rightInfo == null ? true : rightInfo.min > head.value)
        ) {
            // 左树整体已经是搜索二叉树的话，左树上最大二叉搜索子树的大小就是左树的大小
            // 右树同理
            maxSubBSTSize =
                    (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                            +
                            (rightInfo == null ? 0 : rightInfo.maxSubBSTSize)
                            +
                            1;
            isAllBST = true;
        }

        return new Info(isAllBST, maxSubBSTSize, max, min);
    }
}
