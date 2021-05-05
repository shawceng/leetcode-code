package tree;

import java.util.Stack;

public class MinimumDistanceBetweenBSTNodes {
    int minSpan, pre;

    public int minDiffInBST(TreeNode root) {
        minSpan = 200001;
        pre = -10001;
        dfs(root);
        return minSpan;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        minSpan = Math.min(minSpan, root.val - pre);
        pre = root.val;
        dfs(root.right);
    }
}
