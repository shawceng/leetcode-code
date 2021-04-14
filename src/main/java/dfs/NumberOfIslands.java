package dfs;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[][] dp = new boolean[m][n];

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !dp[i][j]) {
                    ret++;
                    dfs(grid, dp, i, j, m, n);
                }
            }
        }
        return ret;
    }

    void dfs(char[][] grid, boolean[][] dp, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] == '0' || dp[i][j]) return;
        dp[i][j] = true;

        dfs(grid, dp, i + 1, j, m, n);
        dfs(grid, dp, i - 1, j, m, n);
        dfs(grid, dp, i, j + 1, m, n);
        dfs(grid, dp, i, j - 1, m, n);
    }
}
