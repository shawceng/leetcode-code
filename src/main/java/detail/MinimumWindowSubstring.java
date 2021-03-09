package detail;

import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int ASCII_COUNT = 256;
        int[] ori = new int[ASCII_COUNT];
        int[] cnt = new int[ASCII_COUNT];
        int expectedCnt = 0;

        for (char c :
                t.toCharArray()) {
            expectedCnt += ori[c] == 0 ? 1 : 0;
            ori[c]++;
        }

        int idx = 0, retLen = Integer.MAX_VALUE;
        int appeared = 0;
        int l = 0, r = 0;

        char[] chars = s.toCharArray();
        while (r < s.length()) {
            if (ori[chars[r]] != 0) {
                cnt[chars[r]]++;
                if (ori[chars[r]] != 0 && cnt[chars[r]] == ori[chars[r]]) {
                    appeared++;
                }
            }
            r++;

            while (l <= s.length() - expectedCnt && (
                    ori[chars[l]] == 0 ||
                            (ori[chars[l]] != 0 && cnt[chars[l]] > ori[chars[l]]))) {
                cnt[chars[l]]--;
                l++;
            }
            if (appeared == expectedCnt && r - l < retLen) {
                idx = l;
                retLen = r - l;
            }
        }
        if (retLen <= s.length())
            return s.substring(idx, idx + retLen);
        return "";
    }
}
