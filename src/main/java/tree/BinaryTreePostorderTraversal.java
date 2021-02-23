package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        traversal(root.left, result);
        traversal(root.right, result);
        result.add(root.val);
    }

}
