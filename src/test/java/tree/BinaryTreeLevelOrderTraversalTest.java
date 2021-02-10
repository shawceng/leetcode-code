package tree;

public class BinaryTreeLevelOrderTraversalTest {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal btot = new BinaryTreeLevelOrderTraversal();
        TreeNode root = TreeNode.createTree(new int[]{3, 9, 20, -1, -1, 15, 7});

        System.out.println(btot.levelOrderRecursion(root));

    }
}
