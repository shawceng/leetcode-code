package lcof;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] map = new int[n];
        map[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n1 = map[a] * 2;
            int n2 = map[b] * 3;
            int n3 = map[c] * 5;
            map[i] = Math.min(n1, Math.min(n2, n3));
            if (map[i] == n1)
                a++;
            if (map[i] == n2)
                b++;
            if (map[i] == n3)
                c++;
        }
        return map[n - 1];
    }
}
