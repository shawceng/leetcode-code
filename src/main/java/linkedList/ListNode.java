package linkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (int each:
             nums) {
            p.next = new ListNode(each);
            p = p.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }
}
