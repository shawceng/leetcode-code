package array;

import java.util.Arrays;

public class FindKthLargestXORCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] xors = new int[m + 1][n + 1];
        int[] res = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                xors[i + 1][j + 1] = xors[i + 1][j] ^ xors[i][j + 1] ^ xors[i][j] ^ matrix[i][j];
                res[i * n + j] = xors[i + 1][j + 1];
            }
        }
        Arrays.sort(res);
        return res[ m * n - k];
    }
}
