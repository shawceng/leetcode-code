package lcof;

import linkedList.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        ListNode m;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                m = l1;
                l1 = l1.next;
            } else {
                m = l2;
                l2 = l2.next;
            }
            p.next = m;
            m.next = null;
            p = m;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
