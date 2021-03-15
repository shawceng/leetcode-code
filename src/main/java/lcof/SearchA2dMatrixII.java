package lcof;

public class SearchA2dMatrixII {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        int col = 0, row = rows - 1;
        while (col < cols && row >= 0) {
            if (matrix[row][col] > target)
                row--;
            else if (matrix[row][col] < target)
                col++;
            else
                return true;
        }
        return false;
    }
}
