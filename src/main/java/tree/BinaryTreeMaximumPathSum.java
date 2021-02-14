package tree;

public class BinaryTreeMaximumPathSum {
    private int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxVal = Integer.MIN_VALUE;
        maxPath(root);
        return maxVal;
    }

    private int maxPath(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = maxPath(root.left);
        int maxRight= maxPath(root.right);
        maxVal = Math.max(maxLeft + maxRight + root.val, maxVal);
        int max = Math.max(maxLeft + root.val, maxRight + root.val);
        return max > 0 ? max : 0;
    }
}
