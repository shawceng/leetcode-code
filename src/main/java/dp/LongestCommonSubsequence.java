package dp;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m > n) return longestCommonSubsequence(text2, text1);
        int[] dp = new int[m + 1];

        for (int i = 0, flag = 0; i < m; i++) {
            if (flag == 1) {
                dp[i + 1] = 1;
                continue;
            }
            if (text1.charAt(i) == text2.charAt(0)) {
                flag = 1;
                dp[i + 1] = flag;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0, pre = 0; j < m; j++) {
                int t = dp[j + 1];
                if (text1.charAt(j) == text2.charAt(i)) {
                    dp[j + 1] = pre + 1;
                }
                dp[j + 1] = Math.max(dp[j + 1], dp[j]);
                pre = t;
            }
        }
        return dp[m];
    }
}
