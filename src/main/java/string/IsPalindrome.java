package string;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int from = 0, to = s.length() - 1;
        while (from < to) {
            while (from < to && !(Character.isAlphabetic(s.charAt(from)) || Character.isDigit(s.charAt(from)))) from ++;
            while (from < to && !(Character.isAlphabetic(s.charAt(to)) || Character.isDigit(s.charAt(to)))) to --;
            if (s.charAt(from) != s.charAt(to)) return false;
            from ++;
            to --;
        }
        return true;
    }
}
