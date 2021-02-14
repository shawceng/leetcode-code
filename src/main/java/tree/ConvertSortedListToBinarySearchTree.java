package tree;

import linkedList.ListNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode dummy = new ListNode(-1, head);
        ListNode p = head, q = dummy;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
        }
        TreeNode right = sortedListToBST(q.next.next);
        TreeNode node = new TreeNode(q.next.val);
        q.next = null;
        TreeNode left = sortedListToBST(dummy.next);
        node.left = left;
        node.right = right;
        return node;
    }
}
