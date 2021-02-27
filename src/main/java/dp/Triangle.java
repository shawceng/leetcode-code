package dp;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = triangle.get(n - 1).get(i);
        dfs(triangle, dp, n - 2);
        return dp[0];
    }

    private void dfs(List<List<Integer>> triangle, int[] dp, int level) {
        if (level < 0) return;
        for (int i = 0; i <= level; i++) {
            dp[i] = triangle.get(level).get(i) + Math.min(dp[i], dp[i + 1]);
        }
        dfs(triangle, dp, level - 1);
    }
}
