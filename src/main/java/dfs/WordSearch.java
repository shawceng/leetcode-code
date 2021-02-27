package dfs;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int th, int m, int n) {
        char c = board[m][n];
        if (th == word.length() - 1 || c != word.charAt(th)) return c == word.charAt(th);

        board[m][n] = 0;
        boolean result = false;
        if (m < board.length - 1) result |= dfs(board, word, th + 1, m + 1, n);
        if (!result && m > 0) result |= dfs(board, word, th + 1, m - 1, n);
        if (!result && n < board[0].length - 1) result |= dfs(board, word, th + 1, m, n + 1);
        if (!result && n > 0) result |= dfs(board, word, th + 1, m, n - 1);
        board[m][n] = c;
        return result;
    }
}
