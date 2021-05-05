package linkedList;

public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) return head;

        ListNode dummy = new ListNode(-1, head);

        int i;
        ListNode pre = dummy;
        for (ListNode p, cur, next; pre.next != null; pre = cur) {
            for (i = 0, cur = pre.next, p = cur; i < k && p != null; i++, p = p.next) ;
            if (i < k && p == null) break;
            // 尾插法
            while (cur.next != p) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
        }
        return dummy.next;
    }
}
