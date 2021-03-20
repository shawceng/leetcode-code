package lcof;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.add(Integer.toString(node.val));
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.add("null");
            }
        }
        for (int i = res.size() - 1; i >= 0 && res.get(i).equals("null"); i--) {
            res.remove(i);
        }
        return "[" + String.join(",", res) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 2) return null;
        String[] items = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(items[0]));
        LinkedList<TreeNode> queue = new LinkedList();
        queue.addLast(root);

        for (int i = 1; i < items.length; i += 2) {
            TreeNode node = queue.removeFirst();
            if (!items[i].equals("null")) {
                node.left = new TreeNode(Integer.valueOf(items[i]));
                queue.addLast(node.left);
            }
            if (i + 1 < items.length && !items[i + 1].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(items[i + 1]));
                queue.addLast(node.right);
            }
        }
        return root;
    }
}
