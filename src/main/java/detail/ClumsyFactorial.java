package detail;

public class ClumsyFactorial {
    public int clumsy(int N) {
        int[] r = {1, 2, 6, 5};
        if (N == 4) return 7;
        if (N < 4) return r[N - 1];
        int ans = 2 * (N - 1);
        int i;
        for (i = N - 4; i > 4; i -= 4) {
            ans -= 4;
        }
        ans -= r[i - 1];
        return ans;
    }
}
