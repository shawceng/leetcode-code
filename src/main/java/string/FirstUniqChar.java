package string;

import java.util.HashMap;

public class FirstUniqChar {
    public char firstUniqChar(String s) {
        char result = ' ';
        char map[] = new char[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }
        return result;
    }
}
