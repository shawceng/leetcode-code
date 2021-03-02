package dp;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] mask = new int[m][n];

        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '0') {
                    mask[i][j] = ++cnt;
                } else
                    cnt = 0;
            }
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mask[i][j] != 0) {
                    int height = 1;
                    int weight = mask[i][j];
                    while (i - height + 1 >= 0) {
                        weight = Math.min(weight, mask[i - height + 1][j]);
                        if (weight == 0) break;
                        ret = Math.max(ret, height * weight);
                        height++;
                    }
                }
            }
        }
        return ret;
    }
}
