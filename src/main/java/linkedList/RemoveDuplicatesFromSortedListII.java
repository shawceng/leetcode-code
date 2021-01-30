package linkedList;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, cur = head.next;

        while (cur != null) {
            if (pre.next.val == cur.val) {
                while (cur == null || cur.val == pre.next.val) cur = cur.next;
                pre.next = cur;
            } else {
                pre = pre.next;
            }
            cur = cur != null ? cur.next : cur;
        }
        return dummy.next;
    }
}
