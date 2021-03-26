package lcof;

import tree.TreeNode;

public class LowestCommonAncestorOfSearchBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        if (root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
