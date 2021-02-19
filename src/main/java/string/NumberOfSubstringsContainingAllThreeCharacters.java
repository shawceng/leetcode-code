package string;

import java.util.Arrays;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int k = s.length();
        int count = 0;
        int[] dp = new int[3];
        Arrays.fill(dp, -1);

        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            dp[ch - 'a'] = i;
            int min = Math.min(dp[0], Math.min(dp[1], dp[2]));
            count += min + 1;
        }
        return count;
    }
}
