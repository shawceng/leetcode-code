package dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0 || n == 0) return m == 0 ? n : m;
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++)
            dp[i] = i;

        int upperLeft;
        for (int i = 1; i < m + 1; i++) {
            upperLeft = dp[0];
            dp[0] = i;
            for (int j = 1; j < n + 1; j++) {
                int t = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[j] = upperLeft;
                else
                    dp[j] = Math.min(dp[j], Math.min(upperLeft, dp[j - 1])) + 1;
                upperLeft = t;
            }
        }
        return dp[n];
    }
}
