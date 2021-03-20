package lcof;

public class NthDigit {
    public int findNthDigit(int n) {
        if (n == 0) return 0;
        long m = 1;
        long d = 9;
        int i = 1;
        while (m + d * i < n) {
            m += d * i;
            i++;
            d *= 10;
        }
        n = n - (int)m;
        long k = d / 9 + n / i;
        n = n % i;
        return String.valueOf(k).charAt(n) - '0';
    }
}
