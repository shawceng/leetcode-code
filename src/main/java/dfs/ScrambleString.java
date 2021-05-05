package dfs;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    String s1, s2;
    int[][][] dp;

    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        int k = s1.length();
        dp = new int[k][k][k];
        return dfs(0, 0, k);
    }

    boolean dfs(int from, int oriFrom, int k) {
        if (k == 1) return s1.charAt(from) == s2.charAt(oriFrom);
        if (dp[k - 1][from][oriFrom] != 0) return dp[k][from][oriFrom] == 2;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++)
            map.put(s1.charAt(from + i), map.getOrDefault(s1.charAt(from + i), 0) + 1);
        for (int i = 0; i < k; i++) {
            int v = map.getOrDefault(s2.charAt(oriFrom + i), 0);
            if (v == 0) {
                dp[k - 1][from][oriFrom] = 1;
                return false;
            }
            map.put(s2.charAt(oriFrom + i), v - 1);
        }


        for (int i = 1; i < k; i++) {
            boolean r = (dfs(from, oriFrom, i) && dfs(from + i, oriFrom + i, k - i))
                    || (dfs(from, oriFrom + k - i, i) && dfs(from + i, oriFrom, k - i));
            if (r) {
                dp[k - 1][from][oriFrom] = 2;
                return true;
            }
        }
        dp[k - 1][from][oriFrom] = 1;
        return false;
    }
}
