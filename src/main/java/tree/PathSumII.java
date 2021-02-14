package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        path(root, result, new ArrayList<Integer>(), targetSum);
        return result;

    }

    public void path(TreeNode root, List<List<Integer>> result, List<Integer> res, int targetSum) {
        if (root == null) return;
        res.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            result.add(List.copyOf(res));
        }
        path(root.left, result, res, targetSum - root.val);
        path(root.right, result, res, targetSum - root.val);
        res.remove(res.size() - 1);
    }
}
