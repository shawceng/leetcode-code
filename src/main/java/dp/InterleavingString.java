package dp;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        int m = s1.length(), n = s2.length();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        for (int i = 1; i <= m; i++)
            dp[i] = dp[i - 1] && s1.charAt(i - 1) == s3.charAt(i - 1);


        for (int i = 1; i <= n; i++) {
            dp[0] = dp[0] && s2.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                dp[j] = (dp[j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1))
                        || (dp[j] && s2.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m];
    }
}
