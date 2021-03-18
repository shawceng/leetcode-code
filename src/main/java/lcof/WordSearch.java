package lcof;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int initial = word.charAt(0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == initial)
                    if (dfs(board, word, i, j, 0))
                        return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j > board[0].length) return false;
        if (board[i][j] == 0 || word.charAt(k) != board[i][j]) return false;

        char c = board[i][j];
        board[i][j] = 0;

        boolean ret = dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1)
                || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = c;
        return ret;
    }
}
