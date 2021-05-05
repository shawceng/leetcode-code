package lcof;

public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) return false;
        int from = 0;
        if (s.charAt(from) == '+' || s.charAt(from) == '-') from++;
        for (int i = from; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                return isBeforePoint(s, i + 1);
            }
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                return isBeforeE(s, i + 1);
            }
            if (!isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    private boolean isBeforeE(String s, int from) {
        if (from == s.length()) return false;
        boolean b = (from > 1 && isDigit(s.charAt(from - 2)))
                || (from > 2 && isDigit(s.charAt(from - 3)));
        return b && (isAllDigit(s, from)
                || ((s.charAt(from) == '+' || s.charAt(from) == '-')
                && isAllDigit(s, from + 1)));
    }

    private boolean isBeforePoint(String s, int from) {
        if (from == s.length()) {
            return from - 2 >= 0 && isDigit(s.charAt(from - 2));
        }


        for (int i = from; i < s.length(); i++) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                return isBeforeE(s, i + 1);
            }
            if (!isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllDigit(String s, int from) {
        if (from >= s.length()) return false;
        for (int i = from; i < s.length(); i++) {
            if (!isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(char c) {
        int v = c - '0';
        return v >= 0 && v < 10;
    }
}
