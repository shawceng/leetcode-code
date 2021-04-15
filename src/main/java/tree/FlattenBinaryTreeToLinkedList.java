package tree;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            if (p.right != null) {
                stack.push(p.right);
                p.right = null;
            }
            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.isEmpty()) {
                p.right = stack.pop();
            }
            p = p.right;
        }
    }

    public void flattenRecursion(TreeNode root) {
        if (root == null) return;

        flattenRecursion(root.left);
        flattenRecursion(root.right);

        if (root.left == null) return;
        TreeNode p = root.left;
        while (p.right != null) p = p.right;
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
