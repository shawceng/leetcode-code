package tree;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preFrom, int preTo, int inFrom, int inTo) {
        if (preFrom == preTo) return null;
        int val = preorder[preFrom];
        int pivot = indexMap.get(val);
        int leftSize = pivot - inFrom;
        TreeNode left = build(preorder, inorder, preFrom + 1, preFrom + 1 + leftSize, inFrom, pivot);
        TreeNode right = build(preorder, inorder, preFrom + leftSize + 1, preTo, pivot + 1, inTo);
        return new TreeNode(val, left, right);
    }

}
