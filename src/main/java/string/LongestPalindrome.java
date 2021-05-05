package string;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        int max = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            for (; (i - j) >= 0 && (i + j) < s.length(); j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) break;
            }
            if (max < j * 2 - 1) {
                max = j * 2 - 1;
                start = i - j + 1;
            }

            for (j = 0; (i - j) >= 0 && (i + j + 1) < s.length(); j++) {
                if (s.charAt(i - j) != s.charAt(i + j + 1)) break;
            }
            if (max < j * 2) {
                max = j * 2;
                start = i - j + 1;
            }
        }
        return s.substring(start, start + max);
    }

    public String longestPalindromeDP(String s) {
        if (s.isEmpty()) return "";
        int l = s.length();
        boolean dp[][] = new boolean[l][l];
        int max = 1, start = 0;
        for (int i = 0; i < l; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]);
                if (dp[j][i] && i - j + 1 > max) {
                    max = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public int dpVal(int dp[][], String s, int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        if (i == j) {
            dp[i][j] = 1;
        } else if (s.charAt(i) != s.charAt(j)) {
            dp[i][j] = -1;
        } else if (s.charAt(i) == s.charAt(j)) {
            int ijVal = dpVal(dp, s, i + 1, j - 1);
            if (ijVal == -1) dp[i][j] = -1;
            else dp[i][j] = ijVal + 2;
        }
        return dp[i][j];
    }
}
