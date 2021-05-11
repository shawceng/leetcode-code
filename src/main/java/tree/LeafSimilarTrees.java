package tree;

import java.util.Stack;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root1);
        s2.push(root2);

        while (!s1.isEmpty() ) {
            TreeNode p1 = s1.pop();
            if (p1.left == null && p1.right == null) {
                if (s2.isEmpty())
                    return false;
                while (!s2.isEmpty()) {
                    TreeNode p2 = s2.pop();
                    if (p2.right != null) {
                        s2.push(p2.right);
                    }
                    if (p2.left != null) {
                        s2.push(p2.left);
                    }
                    if (p2.left == null && p2.right == null) {
                        if (p1.val != p2.val)
                            return false;
                        break;
                    }
                }

            }
            if (p1.right != null) {
                s1.push(p1.right);
            }
            if (p1.left != null) {
                s1.push(p1.left);
            }
        }
        return s1.isEmpty() && s2.isEmpty();
    }
}
