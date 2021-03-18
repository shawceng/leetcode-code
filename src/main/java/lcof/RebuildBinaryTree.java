package lcof;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RebuildBinaryTree {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, 0, preorder.length);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preFrom, int inFrom, int k) {
        if (k <= 0) return null;
        if (k == 1) return new TreeNode(preorder[preFrom]);

        int n = map.get(preorder[preFrom]) - inFrom;
        TreeNode node = new TreeNode(preorder[preFrom]);
        node.left = build(preorder, inorder, preFrom + 1, inFrom, n);
        node.right = build(preorder, inorder, preFrom + n + 1, inFrom + n + 1, k - n - 1);
        return node;
    }
}
