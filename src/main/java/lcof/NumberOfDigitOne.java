package lcof;

public class NumberOfDigitOne {
    int[] f = new int[12];
    public int countDigitOne(int n) {
        if (n == 0) return 0;
        if (n < 10) return 1;

        int p = 1;
        int i = 0;
        while (p <= n / 10) {
            p *= 10;
            i++;
        }
        int k = n / p;
        int l = n % p;

        if (f[i] == 0) {
            f[i] = countDigitOne(p - 1);
        }

        if (k == 1) {
            return f[i] + l + 1 + countDigitOne(l);
        } else {
            return k * f[i] + p + countDigitOne(l);
        }
    }
}
