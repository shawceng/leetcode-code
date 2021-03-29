package tree;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack;
    TreeNode p;
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        if (root != null)
            p = root;
    }

    public int next() {
        int ret = 0;
        while (hasNext()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                ret = p.val;
                p = p.right;
                break;
            }
        }
        return ret;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || p != null;
    }
}
