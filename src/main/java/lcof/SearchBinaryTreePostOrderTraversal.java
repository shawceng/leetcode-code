package lcof;

public class SearchBinaryTreePostOrderTraversal {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] order, int from, int to) {
        if (from >= to - 1) return true;
        int pivot;
        for (pivot = from; pivot <= to && order[pivot] < order[to]; pivot++);
        for (int i = pivot; i < to; i++) {
            if (order[i] < order[to]) {
                return false;
            }
        }
        return verify(order, from, pivot - 1) && verify(order, pivot, to - 1);
    }
}
