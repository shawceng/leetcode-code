package linkedList;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode q = head, p;
        while (q.next != null) {
            if (q.val <= q.next.val) {
                q = q.next;
            } else {
                p = dummy;
                while (p.next != q && q.next.val > p.next.val) p = p.next;
                ListNode t = q.next;
                q.next = t.next;
                t.next = p.next;
                p.next = t;
            }
        }
        return dummy.next;
    }
}
