package tree;

public class SumRootToLeafNumbers {
    private int res = 0;

    public int sumNumbers(TreeNode root) {
        res = 0;
        sumNumbers(root, 0);
        return res;
    }

    private void sumNumbers(TreeNode root, int cur) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            res += cur * 10 + root.val;
        sumNumbers(root.left, cur * 10 + root.val);
        sumNumbers(root.right, cur * 10 + root.val);
    }
}
