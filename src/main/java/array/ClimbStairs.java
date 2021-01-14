package array;

public class ClimbStairs {
    public int climbStairs(int n) {
        int a = 1, b = 2, c = 3;
        if (n < 2) return 1;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
