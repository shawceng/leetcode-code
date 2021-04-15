package linkedList;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow, fast;
        for (slow = head, fast = head.next; fast != null && fast.next != null; fast = fast.next.next, slow = slow.next)
            ;

        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        for (ListNode t; fast != null; ) {
            t = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = t;
            slow = t;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode p = head, q;
        while (p.next != null) {
            q = dummy.next;
            dummy.next = p.next;
            p.next = p.next.next;
            dummy.next.next = q;
        }
        return dummy.next;
    }
}
