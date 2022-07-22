
/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

/*
//单链表
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    // size存储链表元素的个数
    int size;
    // 虚拟头结点
    ListNode head;

    // 初始化链表
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    // 获取第index个节点的数值
    public int get(int index) {
        // 如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        // 包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    // 在链表最前面插入一个节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    // 在链表的最后插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        // 找到要插入节点的前驱
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    // 删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}

 */

// @lc code=start
//单链表
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }
// }

class MyLinkedList {

    // size存储链表元素的个数
    int size;
    // 有个虚拟头,比如找3的时候,2就是虚拟头,不用刻意去找3的前一节点了
    // 虚拟头结点
    // 虚拟头,是带头的单链表.头吧没有意义,但是好用
    ListNode head;

    // 初始化链表
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    // 获取第index个节点的数值
    public int get(int index) {
        // 如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        // 包含一个虚拟头节点，所以查找第 index+1 个节点
        // i <= index
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    // 在链表最前面插入一个节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    // 在链表的最后插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        // 0前插,就是0前插
        if (index < 0) {
            index = 0;
        }
        size++;
        // 找到要插入节点的前驱
        ListNode pred = head;
        // i < index
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    // 删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred = head;
        // i < index
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end
