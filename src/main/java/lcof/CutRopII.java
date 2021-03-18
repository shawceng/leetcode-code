package lcof;

public class CutRopII {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;

        int ret = 1;
        while (n > 4) {
            ret = (ret * 3) % 1000000007;
            n -= 3;
        }
        return (ret * n) % 1000000007;
    }
}
