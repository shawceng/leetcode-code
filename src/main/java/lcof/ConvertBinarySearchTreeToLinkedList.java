package lcof;

public class ConvertBinarySearchTreeToLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);
        Node head = root;
        root.left = root;
        root.right = root;
        if (left != null) {
            root.left = left.left;
            root.right = left;
            root.left.right = root;
            left.left = root;
            head = left;
        }
        if (right != null) {
            root.right = right;
            right.left.right = head;
            head.left = right.left;
            right.left = root;
        }
        return head;
    }
}
