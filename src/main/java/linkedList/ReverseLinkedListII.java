package linkedList;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null || m == n) return head;
        ListNode dummy = new ListNode(0, head);

        head = dummy;
        for (int i = 0; i < m - 1; i++, head = head.next) ;

        ListNode pre = head, p = head.next, q = p.next;

        // 尾插
        for (int i = m; i < n; i++) {
            p.next = q.next;
            q.next = pre.next;
            pre.next = q;
            q = p.next;
        }

        return dummy.next;
    }
}
