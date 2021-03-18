package lcof;

import linkedList.ListNode;

public class KthNodeFromEndOfList {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head, q = head;
        while (k > 0) {
            p = p.next;
            k--;
        }

        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
