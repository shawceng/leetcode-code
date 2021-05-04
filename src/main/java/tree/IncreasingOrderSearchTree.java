package tree;

import java.util.Stack;

public class IncreasingOrderSearchTree {
    TreeNode preNode;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        preNode = dummy;
        inorder(root);
        return dummy.right;
    }

    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        preNode.right = root;
        preNode = root;
        root.left = null;

        inorder(root.right);
    }
}
