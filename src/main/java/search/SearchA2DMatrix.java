package search;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int from = 0, to = m * n;
        int mid;
        while (from < to) {
            mid = from + ((to - from) >> 1);
            int i = mid / n, j = mid % n;
            if (matrix[i][j] < target)
                from = mid + 1;
            else if (matrix[i][j] > target)
                to = mid;
            else
                return true;
        }
        return false;
    }
}
