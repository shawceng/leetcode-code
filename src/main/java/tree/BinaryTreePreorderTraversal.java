package tree;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    private void recursion(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) return;
        res.add(treeNode.val);
        recursion(treeNode.left, res);
        recursion(treeNode.right, res);
    }

}
