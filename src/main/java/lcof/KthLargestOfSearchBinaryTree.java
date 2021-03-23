package lcof;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthLargestOfSearchBinaryTree {
    int ret, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ret;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        --k;
        if (k == 0) ret = root.val;
        dfs(root.left);
    }
}
