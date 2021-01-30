package linkedList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1, head);
        ListNode right, left = dummy;
        while (left.next != null && left.next.val < x) left = left.next;
        right = left;
        while (right != null && right.next != null) {
            if (right.next.val < x) {
                ListNode t = right.next;
                right.next = t.next;
                t.next = left.next;
                left.next = t;
                left = t;
            } else
                right = right.next;
        }
        return dummy.next;
    }
}
