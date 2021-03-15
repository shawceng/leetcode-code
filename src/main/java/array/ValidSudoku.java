package array;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] col = new int[9];
        int[] row = new int[9];
        int[] group = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int val = 1 << (board[i][j] - '1');
                    if ((col[j] & val) != 0
                        || (row[i] & val) != 0
                        || (group[i / 3 * 3 + j / 3] & val) != 0)
                        return false;
                    col[j] |= val;
                    row[i] |= val;
                    group[i / 3 * 3 + j / 3] |= val;
                }
            }
        }
        return true;
    }
}
