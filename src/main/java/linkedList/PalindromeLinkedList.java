package linkedList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode t = slow.next;

        while (t.next != null) {
            ListNode node = t.next;
            t.next = t.next.next;
            node.next = slow.next;
            slow.next = node;
        }

        for (t = slow.next; t != null; t = t.next, head = head.next) {
            if (t.val != head.val) return false;
        }
        return true;
    }
}
