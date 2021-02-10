package tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> r = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.pop();
                r.add(node.val);
                if (node.left != null) queue2.add(node.left);
                if (node.right!= null) queue2.add(node.right);
            }
            res.add(r);
            LinkedList t = queue;
            queue = queue2;
            queue2 = t;
        }
        return res;
    }

    public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) traversal(res, root, 1);
        for (int i = 0; i < res.size(); i++) {
            if ((i & 1) == 1)
                Collections.reverse(res.get(i));
        }
        return res;
    }

    private void traversal(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }

        List<Integer> r = res.get(level - 1);
        r.add(root.val);

        traversal(res, root.left, level + 1);
        traversal(res, root.right, level + 1);
    }
}
