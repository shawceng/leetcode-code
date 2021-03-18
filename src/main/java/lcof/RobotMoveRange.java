package lcof;

public class RobotMoveRange {
    public int movingCount(int m, int n, int k) {
        boolean[][] dp = new boolean[m][n];
        return dfs(dp, 0, 0, k);
    }

    private int dfs(boolean[][] dp, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= dp.length || j >= dp[0].length || dp[i][j] == true) return 0;

        if (k < (i % 10 + i / 10 + j % 10 + j / 10)) {
            return 0;
        }
        dp[i][j] = true;
        return 1 + dfs(dp, i + 1, j, k)
                + dfs(dp, i - 1, j, k)
                + dfs(dp, i, j + 1, k)
                + dfs(dp, i, j - 1, k);
    }

}
