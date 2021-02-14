package tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int from, int to) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (from > to) res.add(null);
        for (int i = from; i <= to; i++) {
            List<TreeNode> lefts = generate(from, i - 1);
            List<TreeNode> rights = generate(i + 1, to);
            for (TreeNode left:
                 lefts) {
                for (TreeNode right:
                     rights) {
                    res.add(new TreeNode(i, left, right));
                }
            }
        }
        return res;
    }
}
