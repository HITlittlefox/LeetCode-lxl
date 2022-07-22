package 代码随想录.数组;

public class test {
    public static void main(String[] args) {
        
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1); // 返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3

    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    };

    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    // // 链表不能按地址直接查询,所以需要遍历查询到index
    // public int get(int index) {
    //     if (index < 0 || index > size) {
    //         return -1;
    //     }
    //     LinkedListNode cur = head;
    //     while(index--!=0){
    //         cur = cur.next;
    //     }
    //     return cur.val;

    // }
    //获取第index个节点的数值
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    // 头部添加
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        // LinkedListNode cur = head;
        newHead.next = head;
        head = newHead;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        ListNode cur = head;
        // cur指到最后一个节点(不是null)
        for (int i = 0; i <= size - 1; i++) {
            cur = cur.next;
        }
        cur.next=newTail;
        newTail.next = null;
        size++;

    }

    public void addAtIndex(int index, int val) {
        ListNode newNodeAtIndex = new ListNode(val);
        ListNode cur = head;
        // cur指到最后一个节点(不是null)
        for (int i = 0; i <= index - 2; i++) {
            cur = cur.next;
        }
        newNodeAtIndex.next = cur.next;
        cur.next=newNodeAtIndex;
        size++;
    }

    public void deleteAtIndex(int index) {
        ListNode cur = head;
        // cur指到最后一个节点(不是null)
        for (int i = 0; i <= index - 2; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}