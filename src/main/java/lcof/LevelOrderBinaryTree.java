package lcof;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBinaryTree {
    public int[] levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.getFirst();
            queue.removeFirst();
            ret.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] result = new int[ret.size()];
        int i = 0;
        for (int e:
             ret) {
            result[i++] = e;
        }
        return result;
    }
}
