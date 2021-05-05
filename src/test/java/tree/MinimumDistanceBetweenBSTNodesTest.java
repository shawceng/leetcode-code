package tree;

public class MinimumDistanceBetweenBSTNodesTest {
    public static void main(String[] args) {
        MinimumDistanceBetweenBSTNodes msb = new MinimumDistanceBetweenBSTNodes();
        System.out.println(msb.minDiffInBST(TreeNode.createTree(new int[]{90, 69, -1, 49, 89, -1, 52})));
    }
}
