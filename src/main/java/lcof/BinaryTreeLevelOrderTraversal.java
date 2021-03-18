package lcof;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        bfs(ret, root, 1);
        return ret;
    }

    private void bfs(List<List<Integer>> ret, TreeNode root, int level) {
        if (root == null) return;
        if (ret.size() < level) {
            ret.add(new ArrayList<>());
        }
        List<Integer> t = ret.get(level - 1);
        t.add(root.val);
        bfs(ret, root.left, level + 1);
        bfs(ret, root.right, level + 1);
    }
}
