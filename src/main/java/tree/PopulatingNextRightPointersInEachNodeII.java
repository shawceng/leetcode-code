package tree;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersInEachNodeII {
    public Node connectRecursion(Node root) {
        if (root == null) return null;

        Node dummy = new Node(-1);
        for (Node cur = root, pre = dummy; cur != null; cur = cur.next) {
            if (cur.left != null) {
                pre.next = cur.left;
                pre = pre.next;
            }
            if (cur.right != null) {
                pre.next = cur.right;
                pre = pre.next;
            }
        }
        connectRecursion(dummy.next);
        return root;
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Node dummy = root;

        while (root != null) {
            Node next = null, prev = null;
            for (; root != null; root = root.next) {
                if (next == null) next = root.left != null ? root.left : root.right;
                if (root.left != null) {
                    if (prev != null) prev.next = root.left;
                    prev = root.left;
                }
                if (root.right != null) {
                    if (prev != null) prev.next = root.right;
                    prev = root.right;
                }
            }
            root = next;
        }

        return dummy;
    }
}
