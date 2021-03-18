package lcof;

public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        int k;
        if (n < 0) {
            k = Math.abs(n + 1);
        } else {
            k = n;
        }
        double ret = 1;
        while (k > 0) {
            double v = x;
            for (int i = 1; i <= k; i = i << 1, v *= v) {
                ret *= v;
                k -= i;
            }
        }
        return n > 0 ? ret : 1 / (ret * x);
    }
}
