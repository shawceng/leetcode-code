package tree;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inFrom, int inTo, int postFrom, int postTo) {
        if (postFrom == postTo) return null;
        int val = postorder[postTo - 1];
        int pivot = indexMap.get(val);
        int leftSize = pivot - inFrom;
        TreeNode left = build(inorder, postorder, inFrom, pivot, postFrom, postFrom + leftSize);
        TreeNode right = build(inorder, postorder, pivot + 1, inTo, postFrom + leftSize, postTo - 1);
        return new TreeNode(val, left, right);
    }

}
