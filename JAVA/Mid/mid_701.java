package JAVA.Mid;

public class mid_701 {

    class Node {
        int val;
        Node prev = null;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public Node head = null;
    public Node tail = null;
    public int size = 0;

    public mid_701() {
    }

    public int get(int index) {
        if (index < 0 | index > size - 1)
            return -1;
        Node cur = this.head;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.val;
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        if (size == 0) {
            this.head = newHead;
            this.tail = newHead;
        } else {
            this.head.prev = newHead;
            newHead.next = this.head;
            this.head = newHead;
        }
        this.size++;
    }

    public void addAtTail(int val) {
        Node newTail = new Node(val);
        if (size == 0) {
            this.head = newTail;
            this.tail = newTail;
        } else {
            this.tail.next = newTail;
            newTail.prev = this.tail;
            this.tail = newTail;
        }
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 | index > this.size)
            return;
        if (index == 0) {
            this.addAtHead(val);
            return;
        }
        if (index == this.size) {
            this.addAtTail(val);
            return;
        }
        Node cur = this.head;
        for (int i = 1; i < index; i++) {
            if (cur == null)
                return;
            cur = cur.next;
        }
        Node newNode = new Node(val);
        Node next = cur.next;
        newNode.prev = cur;
        newNode.next = next;
        cur.next = newNode;
        next.prev = newNode;
        this.size++;
    }

    public void deleteAtIndex(int index) {
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            if (cur == null)
                return;
            cur = cur.next;
        }
        if (cur == null)
            return;
        if (cur == this.head) {
            this.head = cur.next;
            if (this.head != null)
                this.head.prev = null;
        }
        if (cur == this.tail) {
            this.tail = cur.prev;
            if (this.tail != null)
                this.tail.next = null;
        }
        Node pre = cur.prev;
        Node next = cur.next;
        if (pre != null)
            pre.next = next;
        if (next != null)
            next.prev = pre;
        this.size--;
    }
}
