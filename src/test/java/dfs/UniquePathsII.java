package dfs;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[] = new int[obstacleGrid[0].length];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) dp[0] = 0;
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j] + dp[j - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
