package linkedList;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        for (Node cur = head; cur != null; ) {
            Node t = new Node(cur.val);
            t.next = cur.next;
            cur.next = t;
            cur = t.next;
        }

        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
        }

        Node dummy = new Node(-1);
        dummy.next = head;

        for (Node pre = dummy, cur = head; cur != null; cur = cur.next, pre = pre.next) {
            pre.next = cur.next;
            cur.next = cur.next.next;
        }
        return dummy.next;
    }
}
