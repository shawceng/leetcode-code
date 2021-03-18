package lcof;

public class Fibonacci {
    public int fib(int n) {
        int[] f = new int[]{0, 1};
        if (n < 2) return f[n];

        for (int i = 2; i < n; i++) {
            int t = f[0] + f[1];
            t %= 1000000007;
            f[0] = f[1];
            f[1] = t;
        }

        return (f[1] + f[0]) % 1000000007;
    }
}
