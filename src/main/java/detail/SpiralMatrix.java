package detail;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ret = new ArrayList<>(m * n);
        int x = 0, y = 0;
        while (true) {
            int i, j;
            for (i = x, j = y; j < n - 1; j++) {
                ret.add(matrix[i][j]);
            }
            for (; i < m - 1; i++) {
                ret.add(matrix[i][j]);
            }
            for (; j > y && x != m - 1; j--) {
                ret.add(matrix[i][j]);
            }
            for (; i > x && y != n - 1; i--) {
                ret.add(matrix[i][j]);
            }
            x++;
            y++;
            m--;
            n--;
            if (x >= m || y >= n) {
                if (x > m || y > n) ret.add(matrix[i][j]);
                break;
            }
        }
        return ret;
    }
}
