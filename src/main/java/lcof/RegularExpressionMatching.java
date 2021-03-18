package lcof;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        return match(s, p, 0, 0);
    }

    private boolean match(String s, String p, int sFrom, int pFrom) {
        if (pFrom == p.length()) return sFrom == s.length();

        boolean b = false;
        if (pFrom + 1 < p.length() && p.charAt(pFrom + 1) == '*') {
            char c = p.charAt(pFrom);
            b = match(s, p, sFrom, pFrom + 2);
            for (int i = sFrom; i < s.length() && (c == '.' || s.charAt(i) == c); i++) {
                b |= match(s, p, i + 1, pFrom + 2);
                if (b) return true;
            }
        } else {
            return sFrom < s.length()
                    && (p.charAt(pFrom) == '.'
                    || (p.charAt(pFrom) == s.charAt(sFrom)))
                    && match(s, p, sFrom + 1, pFrom + 1);
        }
        return b;
    }
}
