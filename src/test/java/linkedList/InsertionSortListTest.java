package linkedList;

public class InsertionSortListTest {
    public static void main(String[] args) {
        InsertionSortList isl = new InsertionSortList();
        ListNode l = ListNode.createList(new int[]{4, 2, 1, 3});
        ListNode.printList(isl.insertionSortList(l));
    }
}
