package linkedList;

public class SortListTest {
    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode.printList(sl.sortList(ListNode.createList(new int[]{3, 4,1,2, 9, 7})));
    }
}
