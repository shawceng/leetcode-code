package string;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean isMatch(char[] s, char[] p, int start1, int start2) {
        if (start2 == p.length) return start1 == s.length;

        if (start1 >= s.length) {
            if (start2 < p.length - 1)
                return p[start2 + 1] == '*' && isMatch(s, p, start1, start2 + 2);
            else
                return false;
        }

        if (start2 < p.length - 1 && p[start2 + 1] == '*') {
            return isMatch(s, p, start1, start2 + 2)
                    || ((p[start2] == s[start1] || p[start2] == '.')
                            && (isMatch(s, p, start1 + 1, start2) || isMatch(s, p, start1 + 1, start2 + 2)));
        } else {
            return (p[start2] == '.' || p[start2] == s[start1])
                    && isMatch(s, p, start1 + 1, start2 + 1);
        }
    }
}
