package detail;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = dividend > 0 ? dividend : -(long) dividend;
        long b = divisor > 0 ? divisor : -(long) divisor;

        int ret = 0;
        while (a >= b) {
            long c = b;
            for (int i = 0; a >= c; i++, c = c << 1) {
                a -= c;
                ret += 1 << i;
            }
        }
        return ((dividend ^ divisor) >> 31) == 0 ? ret : -ret;
    }
}
