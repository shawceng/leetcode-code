package tree;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long low, long high) {
        if (root == null) return true;
        return root.val < high && root.val > low
                && isValidBST(root.left, low, root.val)
                && isValidBST(root.right, root.val, high);
    }
}
