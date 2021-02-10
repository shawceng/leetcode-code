package tree;

public class BinaryTreePreorderTraversalTest {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new int[]{1, -1, 2, 3});
        BinaryTreePreorderTraversal btpt = new BinaryTreePreorderTraversal();
        System.out.println(btpt.preorderTraversal(root));

    }
}
