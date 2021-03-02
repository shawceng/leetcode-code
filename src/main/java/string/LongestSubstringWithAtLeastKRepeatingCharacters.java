package string;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if (k < 2) return s.length();
        if (k > s.length()) return 0;
        return dfs(s, 0, s.length(), k);
    }

    private int dfs(String s, int from, int to, int k) {
        int[] map = new int[26];
        for (int i = from; i < to; i++)
            map[s.charAt(i) - 'a']++;

        char c = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0 && map[i] < k) {
                c = (char) ('a' + i);
                break;
            }
        }

        if (c == 0) return to - from;

        int ret = 0;
        int l = from, r = from;
        while (r <= to) {
            if (r == to || s.charAt(r) == c) {
                if (r - l >= k) {
                    ret = Math.max(dfs(s, l, r, k), ret);
                }
                l = r + 1;
            }
            r++;
        }
        return ret;
    }
}
