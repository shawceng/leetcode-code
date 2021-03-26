package lcof;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new Stack<>(), root, target);
        return ret;
    }

    void dfs(List<List<Integer>> ret, Stack<Integer> path, TreeNode root, int target) {
        if (root == null) return;
        target -= root.val;
        path.push(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(path));
            path.pop();
            return;
        }
        dfs(ret, path, root.left, target);
        dfs(ret, path, root.right, target);
        path.pop();
    }
}
