package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        Set<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = 0;
        for (String e :
                wordDict) {
            set.add(e);
            min = Math.min(min, e.length());
            max = Math.max(max, e.length());
        }

        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = min; i <= m; i++)
            for (int j = Math.max(0, i - max); j < i && dp[i] == false; j++) {
                if (i - j < min) break;
                dp[i] = dp[j] && set.contains(s.substring(j, i));
            }
        return dp[m];
    }
}
