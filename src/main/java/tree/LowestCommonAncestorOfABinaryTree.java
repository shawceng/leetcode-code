package tree;

public class LowestCommonAncestorOfABinaryTree {
    TreeNode ancestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestor = null;
        findAncestor(root, p.val, q.val);
        return ancestor;
    }

    boolean findAncestor(TreeNode root, int p, int q) {
        if (root == null || ancestor != null) return false;
        boolean r = root.val == p || root.val == q;

        boolean left = findAncestor(root.left, p, q);
        boolean right = findAncestor(root.right, p, q);
        if ((r && left) || (r && right) || (left && right)) {
            ancestor = root;
        }
        return r || left || right;
    }
}
