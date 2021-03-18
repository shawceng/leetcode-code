package lcof;

public class CutRop {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] map = new int[n + 1];
        map[1] = 1;
        map[2] = 2;
        map[3] = 3;

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= (i >> 1); j++) {
                map[i] = Math.max(map[j] * map[i - j], map[i]);
            }
        }
        return map[n];
    }
}
