package class09;

public class Code03_SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 笔试
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        // 拿到长度
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        // 有i个节点的列表
        // ()->()->()->()->()->null
        Node[] nodeArr = new Node[i];
        i = 0;
        // 指回头节点
        cur = head;
        // 数组转容器
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        printLinkedList(head);

        // 把nodeArr[0]，当成头节点
        // nodeArr[0]->nodeArr[1]->nodeArr[2]
        // 以nodeArr[0]为头的一个链表，当成数组
        printLinkedList(nodeArr[0]);

        // 把数组调整好位置（位置对了，但是节点指向目前还不对）
        arrPartition(nodeArr, pivot);
        // 依次串起来（让节点指向也对了），返回。
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    // TODO:荷兰国旗问题
    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }


    // 面试
    // 3. 分成小、中、大三部分。再把各个部分之间串起来（面试用）
    //  1. 借助6个引用变量，不需要容器O(N)，且能保证稳定性。
    //  2. 小于区域的头引用，小于区域的尾引用，
    //  3. 等于区域的头引用，等于区域的尾引用，
    //  4. 大于区域的头引用，大于区域的尾引用。
    //  5. 依次对比给定的值加入到这三个区域，之后串联起来
    public static Node listPartition2(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node mH = null; // big head
        Node mT = null; // big tail
        Node next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;//提前记一下环境
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    // 老尾巴的下一个节点指向当前节点
                    sT.next = head;
                    // 当前节点变成新尾巴
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        // 小于区域的尾巴，连，等于区域的头，
        // 等于区域的尾巴，连，大于区域的头
        if (sT != null) { // 如果有小于区域
            sT.next = eH;
            eT = (eT == null) ? sT : eT; // 下一步，谁去连大于区域的头，谁就变成eT
        }
        // 下一步，一定是需要用eT 去接 大于区域的头
        // 有等于区域，eT -> 等于区域的尾结点
        // 无等于区域，eT -> 小于区域的尾结点
        // eT 尽量不为空的尾巴节点
        if (eT != null) { // 如果小于区域和等于区域，不是都没有
            eT.next = mH;
        }
        // 返回头是谁
        return (sH != null) ? sH : ((eH != null) ? eH : mH);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
//        printLinkedList(head1);
//        // head1 = listPartition1(head1, 4);
//        head1 = listPartition2(head1, 5);
//        printLinkedList(head1);

        head1 = listPartition1(head1, 5);
        printLinkedList(head1);
    }

}
