package tree;

public class BinaryTreeMaximumPathSumTest {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum btmps = new BinaryTreeMaximumPathSum();
        TreeNode root = TreeNode.createTree(new int[]{-10,9,20,-1,-1,15,7});
        System.out.println(btmps.maxPathSum(root));
    }
}
