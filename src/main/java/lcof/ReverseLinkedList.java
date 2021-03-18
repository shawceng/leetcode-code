package lcof;

import linkedList.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode p = head;
        while (p.next != null) {
            ListNode q = p.next;
            p.next = q.next;
            q.next = dummy.next;
            dummy.next = q;
        }
        return dummy.next;
    }
}
