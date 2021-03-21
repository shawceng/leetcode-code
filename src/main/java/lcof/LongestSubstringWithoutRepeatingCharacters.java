package lcof;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int from = 0, to = 0;
        int max = 0;
        while (to < s.length()) {
            char c = s.charAt(to);
            if (map[c] == -1 || map[c] < from) {
                map[c] = to;
                to++;
            } else {
                max = Math.max(max, to - from);
                from = map[c] + 1;
            }
        }
        max = Math.max(max, to - from);
        return max;
    }
}
