package dp;

import java.util.HashMap;

public class ScrambleString {
    public boolean isScrambleDP(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int m = s1.length();
        boolean[][][] dp = new boolean[m + 1][m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp[1][i][j] = true;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                for (int k = 1; k <= m - j && k <= m - i; k++) {
                    boolean r;
                    for (int step = 1; step < k; step++) {
                        int step2 = k - step;
                        r = (dp[step][i][j] && dp[step2][i + step][j + step]
                                || dp[step][i][j + step2] && dp[step2][i + step][j]);
                        if (r == true) {
                            dp[k][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[m][0][0];
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return isScramble(s1, s2, 0, s1.length(), 0, s2.length());
    }

    private boolean isScramble(String s1, String s2, int from, int to, int from2, int to2) {
        if (to - from == 1) return s1.charAt(from) == s2.charAt(from2);
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = from; i < to; i++) {
            char c = s1.charAt(i);
            if (!map.containsKey(c))
                map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        for (int i = from2; i < to2; i++) {
            char c = s2.charAt(i);
            if (!map.containsKey(c) || map.get(c) <= 0)
                return false;
            map.put(c, map.get(c) - 1);
        }

        int d = to - from;
        for (int step = 1; step < d; step++) {
            int step2 = to - from - step;
            if ((isScramble(s1, s2, from, from + step, from2, from2 + step)
                    && isScramble(s1, s2, from + step, to, from2 + step, to2))
                    || (isScramble(s1, s2, from, from + step, from2 + step2, to2)
                    && isScramble(s1, s2, from + step, to, from2, from2 + step2)))
                    return true;
        }

        return false;
    }
}
