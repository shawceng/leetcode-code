package linkedList;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow2 = head;
        for (ListNode fast = head.next.next, slow = head.next;
             fast != null && fast.next != null;
             slow = slow.next, fast = fast.next.next) {
            if (slow == fast) {
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }
}
