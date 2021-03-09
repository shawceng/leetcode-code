package detail;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int count = 0;

        int m = 0;
        int i, j;
        while (m < n - 1) {
            for (i = m, j = m; j < n - 1; j++)
                ret[i][j] = ++count;
            for (; i < n - 1; i++)
                ret[i][j] = ++count;
            for (; j > m; j--)
                ret[i][j] = ++count;
            for (; i > m; i--)
                ret[i][j] = ++count;
            m++;
            n--;
        }
        if (m != n) ret[m][m] = ++count;
        return ret;
    }
}
