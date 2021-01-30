package linkedList;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;

        for (ListNode p, q; pre.next != null && pre.next.next != null; pre = pre.next.next) {
            p = pre.next;
            q = p.next;
            pre.next = q;
            p.next = q.next;
            q.next = p;
        }
        return dummy.next;
    }
}
