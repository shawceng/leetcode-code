package tree;

import java.util.List;

public class UniqueBinarySearchTreeIITest {
    public static void main(String[] args) {
        UniqueBinarySearchTreeII uniqueBinarySearchTreeII = new UniqueBinarySearchTreeII();
        List<TreeNode> res = uniqueBinarySearchTreeII.generateTrees(3);
        for (TreeNode root:
             res) {
            System.out.println(TreeNode.preorderTraversal(root));
        }
    }
}
