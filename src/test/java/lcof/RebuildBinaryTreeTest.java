package lcof;

import tree.TreeNode;

public class RebuildBinaryTreeTest {
    public static void main(String[] args) {
        RebuildBinaryTree bt = new RebuildBinaryTree();
        TreeNode tree = bt.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        System.out.println(TreeNode.preorderTraversal(tree));
    }
}
