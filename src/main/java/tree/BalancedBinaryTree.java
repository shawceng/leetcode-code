package tree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return heightBanlanced(root) >= 0;
    }

    private int heightBanlanced(TreeNode p) {
        if (p == null) return 0;

        int left = heightBanlanced(p.left);
        int right = heightBanlanced(p.right);

        if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
