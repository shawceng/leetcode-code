package linkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.next == null && l1.val == 0) return l2;
        if (l2.next == null && l2.val == 0) return l1;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0, a, b;

        while (l1 != null || l2 != null) {
            a = 0;
            b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode((a + b + carry) % 10);
            p = p.next;
            carry = (a + b + carry) / 10;
        }
        if (carry != 0)
            p.next = new ListNode(carry);
        return dummy.next;
    }
}
