package tree;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        return minDepth(root, false);
    }

    private int minDepth(TreeNode root, boolean hasbrother) {
        if (root == null) return hasbrother ? Integer.MAX_VALUE : 0;

        return 1 + Math.min(minDepth(root.left, root.right != null),
                minDepth(root.right, root.left != null));
    }
}
