package linkedList;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length);

    }

    private ListNode merge(ListNode[] lists, int from, int to) {
        if (from >= to) return null;
        if (from == to - 1) return lists[from];

        int mid = from + ((to - from) >> 1);
        return mergeTwoList(merge(lists, from, mid), merge(lists, mid, to));
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null || l2 != null)
            p.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    public ListNode mergeKListsNormal(ListNode[] lists) {
        int k = lists.length;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode minNode;
        int min, mini = 0;
        while (true) {
            minNode = null;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                while (lists[i] == null && i < k) {
                    lists[i] = lists[--k];
                }
                if (lists[i] == null) {
                    continue;
                }
                if (lists[i].val < min) {
                    minNode = lists[i];
                    min = minNode.val;
                    mini = i;
                }
            }
            if (minNode == null) break;
            lists[mini] = minNode.next;
            p.next = minNode;
            p = p.next;
        }
        return dummy.next;
    }
}
