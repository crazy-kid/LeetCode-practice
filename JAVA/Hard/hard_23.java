package JAVA.Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class hard_23 {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[2];

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
            cur.next = smallest;
            cur = smallest;
        }
    }
}
