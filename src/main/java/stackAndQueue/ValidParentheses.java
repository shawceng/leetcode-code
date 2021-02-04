package stackAndQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() <= 1) return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        ArrayList<Character> stack = new ArrayList<>();
        for (char c:
             s.toCharArray()) {
            if (map.containsValue(c))
                stack.add(c);
            else if (stack.size() > 0 && map.get(c) == stack.indexOf(stack.size() - 1))
                stack.remove(stack.size() - 1);
            else
                return false;
        }
        if (stack.size() > 0) return false;
        return true;
    }
}
