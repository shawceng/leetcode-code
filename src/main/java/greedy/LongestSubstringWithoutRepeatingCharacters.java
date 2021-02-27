package greedy;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int result = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] >= start) {
                result = Math.max(result, i - start);
                start = map[s.charAt(i)] + 1;
            }
            map[s.charAt(i)] = i;
        }
        return Math.max(s.length() - start, result);
    }
}
