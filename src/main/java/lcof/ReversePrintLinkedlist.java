package lcof;

import linkedList.ListNode;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class ReversePrintLinkedlist {
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        int k = 0;
        while (p != null) {
            p = p.next;
            k++;
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[k - i - 1] = head.val;
            head = head.next;
        }
        return ret;
    }
}
