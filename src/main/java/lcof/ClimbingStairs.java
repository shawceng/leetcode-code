package lcof;

public class ClimbingStairs {
    public int numWays(int n) {
        int[] f = new int[]{1, 1};
        if (n < 2) return f[n];

        int t = 0;
        for (int i = 2; i <= n; i++) {
            t = (f[0] + f[1]) % 1000000007;
            f[0] = f[1];
            f[1] = t;
        }
        return t;
    }
}
