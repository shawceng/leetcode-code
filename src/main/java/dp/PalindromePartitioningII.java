package dp;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i <= n; i++) {
            f[i] = n - 1 - i;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <=2 ||  dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    f[i] = Math.min(f[j + 1] + 1, f[i]);
                }
            }
        }
        return f[0];
    }
}
