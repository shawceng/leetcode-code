package tree;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] r = dfs(root);
        return Math.max(r[0], r[1]);
    }

    int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
