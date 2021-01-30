package linkedList;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy, q = dummy;
        for (; n > 0 && q != null; n--, q = q.next);

        for (; q.next != null; q = q.next, p = p.next);

        p.next = p.next.next;

        return dummy.next;

    }
}
