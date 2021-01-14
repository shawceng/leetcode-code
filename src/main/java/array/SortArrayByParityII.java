package array;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        if (A.length < 2) return A;
        int from = 0, to = 1, tmp;
        while (from < A.length && to < A.length) {
            while (from < A.length && (A[from] & 1) == 0) from += 2;
            while (to < A.length && (A[to] & 1) == 1) to += 2;
            if (to < A.length && from < A.length) {
                tmp = A[from];
                A[from] = A[to];
                A[to] = tmp;
            }

        }
        return A;
    }
}
