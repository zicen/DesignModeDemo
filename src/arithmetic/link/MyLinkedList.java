package arithmetic.link;

/**
 * 自定义单链表
 */
public class MyLinkedList {
    class ListNode {
        public ListNode next;
        public int val;

        public ListNode(int value) {
            this.val = value;
        }
    }
    private int size;
    private ListNode head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size || index < 0 ){
            return -1;
        }
        ListNode curr = head;
        for(int i = 0 ;i < index+1; ++i){
            curr = curr.next;
        }
        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index < 0) index = 0;
        size ++;
        ListNode pred = head;
        for(int i = 0 ; i < index; ++i) pred = pred.next;
        ListNode addNode = new ListNode(val);
        addNode.next = pred.next;
        pred.next = addNode;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0) return;
        size--;
        ListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;
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