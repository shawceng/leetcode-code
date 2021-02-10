package tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal cbt = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode root = cbt.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(TreeNode.preorderTraversal(root));
    }
}
