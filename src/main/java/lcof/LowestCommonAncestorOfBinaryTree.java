package lcof;

import tree.TreeNode;

public class LowestCommonAncestorOfBinaryTree {
    TreeNode node;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root, p, q);
        return node;
    }

    boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (node != null) return true;
        if (root == null) return false;
        boolean left = findNode(root.left, p, q);
        boolean right = findNode(root.right, p, q);
        if (node != null) return true;
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
            node = root;
            return true;
        }
        if (root.val == q.val || root.val == p.val || left || right) return true;
        return false;
    }
}
