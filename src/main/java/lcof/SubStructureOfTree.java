package lcof;

import tree.TreeNode;

import java.util.Stack;

public class SubStructureOfTree {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isSame(A, B) || (isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean isSame(TreeNode A, TreeNode B) {
        if (A == null) return B == null;
        if (B == null) return true;
        if (A.val != B.val) return false;

        return isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}
