package dp;

import java.util.Arrays;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int m = s.length();
        int last = 1, cur = s.charAt(m - 1) != '0' ? 1 : 0;

        for (int i = m - 2; i >= 0; i--) {
            int t = cur;
            cur = 0;
            if (s.charAt(i) != '0') {
                cur += t;
                if (Integer.valueOf(s.substring(i, i + 2)) <= 26)
                    cur += last;
            }
            last = t;
        }
        return cur;
    }
}
