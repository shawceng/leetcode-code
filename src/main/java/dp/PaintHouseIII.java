package dp;

import java.util.Arrays;

public class PaintHouseIII {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int MAXVAL = 1000001;
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], MAXVAL);
            }
        }

        if (houses[0] != 0)
            dp[0][houses[0] - 1][0] = 0;
        else
            for (int i = 0; i < n; i++)
                dp[0][i][0] = cost[0][i];

        for (int i = 1; i < houses.length; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < target; k++) {
                    if (dp[i - 1][j][k] == MAXVAL) continue;
                    if (houses[i] != 0) {
                        if (j != houses[i] - 1 && k < target - 1)
                            dp[i][houses[i] - 1][k + 1] = Math.min(dp[i - 1][j][k], dp[i][houses[i] - 1][k + 1]);
                        if (j == houses[i] - 1)
                            dp[i][houses[i] - 1][k] = Math.min(dp[i - 1][j][k], dp[i][houses[i] - 1][k]);
                        continue;
                    }
                    for (int l = 0; l < n; l++) {
                        int v = cost[i][l];
                        if (j == l) {
                            dp[i][l][k] = Math.min(dp[i - 1][j][k] + v, dp[i][l][k]);
                        } else if (k < target - 1){
                            dp[i][l][k + 1] = Math.min(dp[i][l][k + 1], dp[i - 1][j][k] + v);
                        }
                    }
                }
            }
        }

        int ret = MAXVAL;
        for (int i = 0; i < n; i++) {
            ret = Math.min(ret, dp[m - 1][i][target - 1]);
        }
        if (ret == MAXVAL)
            return -1;
        else
            return ret;
    }
}
