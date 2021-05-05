package string;

import java.util.HashMap;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int map[] = new int[26];
        for (char c :
                s.toCharArray()) {
            map[c - 'a'] += 1;
        }

        for (char c :
                t.toCharArray()) {
            int val = map[c - 'a'];
            if (val <= 0) return false;
            map[c - 'a'] -= 1;
        }

        for (int val :
                map) {
            if (val != 0) return false;
        }

        return true;
    }
}
