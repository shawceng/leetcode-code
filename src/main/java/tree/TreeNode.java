package tree;

import com.sun.source.tree.Tree;

import java.util.List;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(int[] arr) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(arr[0]);
        stack.push(root);

        for (int i = 1; i < arr.length; i += 2) {
            TreeNode node = stack.pop();
            if (i + 1 < arr.length && arr[i + 1] != -1) {
                node.right = new TreeNode(arr[i + 1]);
                stack.push(node.right);
            }
            if (arr[i] != -1) {
                node.left = new TreeNode(arr[i]);
                stack.push(node.left);
            }
        }
        return root;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        BinaryTreePreorderTraversal btpt = new BinaryTreePreorderTraversal();
        return btpt.preorderTraversalRecursion(root);
    }
}
