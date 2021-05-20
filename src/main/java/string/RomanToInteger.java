package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    char[] CHARS = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int[] NUMS = {1, 5, 10, 50, 100, 500, 1000};

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < CHARS.length; i++) {
            map.put(CHARS[i], NUMS[i]);
        }

        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                ret += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else {
                ret += map.get(s.charAt(i));
            }
        }
        return ret;
    }
}
