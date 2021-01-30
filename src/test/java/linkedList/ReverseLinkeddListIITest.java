package linkedList;

public class ReverseLinkeddListIITest {
    public static void main(String[] args) {
        ListNode list = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ReverseLinkedListII rll = new ReverseLinkedListII();
        rll.reverseBetween(list, 2, 5);
        ListNode.printList(list);
    }

}
