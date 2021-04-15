package stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] f = new int[s.length() + 1];
        int max = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) != '(') continue;
            int matched = i + f[i + 1] + 1;
            if (matched < s.length() && s.charAt(matched) == ')')
                f[i] = matched + 1 - i + f[matched + 1];
            max = Math.max(max, f[i]);
        }
        return max;
    }

    public int longestValidParenthesesStack(String s) {
        LinkedList<Integer> stack = new LinkedList<>();

        int max_len = 0, last = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty())
                        max_len = Math.max((max_len), i - last);
                    else
                        max_len = Math.max(max_len, i - stack.peek());
                }
            }
        }
        return max_len;
    }

    public int longestValidParenthesesTwo(String s) {
        int max = 0, start = -1, depth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ++depth;
            } else {
                --depth;
                if (depth < 0) {
                    start = i;
                    depth = 0;
                } else if (depth == 0) {
                    max = Math.max(max, i - start);
                }
            }
        }

        depth = 0;
        start = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                ++depth;
            } else {
                --depth;
                if (depth < 0) {
                    start = i;
                    depth = 0;
                } else if (depth == 0) {
                    max = Math.max(max, start - i);
                }
            }
        }

        return max;
    }
}
