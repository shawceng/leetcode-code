package linkedList;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = 1;
        ListNode front = head, rear = head;
        for (; rear.next != null; len++, rear = rear.next) ;

        if (k % len == 0) return head;
        k = len - (k % len);

        ListNode dummy = new ListNode(-1, head);

        for (; k > 1; k--, front = front.next) ;

        dummy.next = front.next;
        front.next = null;
        rear.next = head;

        return dummy.next;
    }
}
