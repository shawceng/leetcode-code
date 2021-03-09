package dp;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        if (wordDict.size() == 0 || m == 0) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = 0;
        for (String e:
             wordDict) {
            set.add(e);
            min = Math.min(min, e.length());
            max = Math.max(max, e.length());
        }

        boolean[][] dp = new boolean[m + 1][m + 1];
        dp[0][0] = true;
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int i = 0; i <= m; i++) {
            int maxStep = Math.min(m, i + max);
            if (!f[i]) continue;
            for (int j = i + min; j <= maxStep; j++) {
                if (set.contains(s.substring(i, j))) {
                    f[j] = true;
                    dp[i][j] = true;
                }
            }
        }
        ArrayList<String> ret = new ArrayList<>();
        if (!f[m]) return ret;
        dfs(ret, new Stack<>(), s, dp, 0, min, max);
        return ret;
    }

    private void dfs(List<String> ret, Stack<String> path, String s, boolean[][] dp, int k, int min, int max) {
        if (k == s.length()) {
            ret.add(String.join(" ", path));
            return;
        }
        for (int i = k + min; i <= s.length() && i <= k + max; i++) {
            if (dp[k][i]) {
                path.push(s.substring(k, i));
                dfs(ret, path, s, dp, i, min, max);
                path.pop();
            }
        }
    }
}
