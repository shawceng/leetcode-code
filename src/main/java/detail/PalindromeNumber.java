package detail;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int t = 0;
        while (t < x) {
            t = t * 10 + x % 10;
            x /= 10;
        }
        return x == t || x == t / 10;
    }
}
