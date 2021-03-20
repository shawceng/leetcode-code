package lcof;

import tree.TreeNode;

public class CodecTest {
    public static void main(String[] args) {
        Codec cc = new Codec();
        TreeNode root = TreeNode.createTree(new int[]{1, 2, 3, -1, -1, 4, 5});
        System.out.println(cc.serialize(root));
        System.out.println(TreeNode.preorderTraversal(cc.deserialize("[-1,2,-3,null,null,4,5]")));
    }
}
