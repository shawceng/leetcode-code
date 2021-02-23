package dfs;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] groups = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    setVal(board, rows, cols, groups, i, j, board[i][j] - '1', 1);
                }
            }
        }
        solve(board, rows, cols, groups, 0);
    }

    private boolean solve(char[][] board, int[] rows, int[] cols, int[] groups, int n) {
        if (n >= 81) return true;
        int i = n / 9;
        int j = n % 9;
        if (board[i][j] != '.') {
            return solve(board, rows, cols, groups, n + 1);
        }
        int val = rows[i] | cols[j] | groups[(i / 3) * 3 + (j / 3)];
        for (int k = 0; k < 9; k++) {
            if (((val >> k) & 1) == 1) continue;
            board[i][j] = (char) ('1' + k);
            setVal(board, rows, cols, groups, i, j,  k, 1);
            boolean b = solve(board, rows, cols, groups, n + 1);
            setVal(board, rows, cols, groups, i, j,  k, -1);
            if (b) return true;
            board[i][j] = '.';
        }
        return false;
    }

    private void setVal(char[][] board, int[] rows, int[] cols, int[] groups, int i, int j, int val, int flag) {
        val = 1 << val;
        val *= flag;
        cols[j] += val;
        rows[i] += val;
        groups[(i / 3) * 3 + (j / 3)] += val;
    }
}
