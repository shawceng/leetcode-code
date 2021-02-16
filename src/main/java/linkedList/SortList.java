package linkedList;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head, q = head.next;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        q = p.next;
        p.next = null;
        return mergeTwoList(sortList(head), sortList(q));

    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        else p.next = l2;
        return dummy.next;
    }
}
