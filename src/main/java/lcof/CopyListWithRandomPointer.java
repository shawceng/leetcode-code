package lcof;



public class CopyListWithRandomPointer {
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

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node p = head;
        while (p != null) {
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }

        p = head;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }

        Node newHead = head.next, q = newHead;
        p = head;
        while (p != null) {
            p.next = q.next;
            q.next = q.next == null ? null : q.next.next;
            p = p.next;
            q = q.next;
        }
        return newHead;
    }
}
