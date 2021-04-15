package array;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        if (A.length == 0) return A;
        int from = 0, to = A.length - 1;

        while (from < to) {
            while (from < to && (A[from] & 1) == 0) from++;
            while (from < to && (A[to] & 1) == 1) to--;
            swap(A, from, to);
        }
        return A;
    }

    public void swap(int[] A, int from, int to) {
        int tmp = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }
}
