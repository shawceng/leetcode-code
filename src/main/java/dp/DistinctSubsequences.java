package dp;

import java.util.Arrays;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();

        int[] dp = new int[m + 1];
        Arrays.fill(dp, 1);

        for (int i = 1; i <= n; i++) {
            int pre = dp[i - 1];
            dp[i - 1] = 0;
            for (int j = i; j <= m; j++) {
                int tmp = dp[j];
                dp[j] = dp[j - 1] + (s.charAt(j - 1) == t.charAt(i - 1) ? pre : 0);
                pre = tmp;
            }
        }
        return dp[m];
    }
}
