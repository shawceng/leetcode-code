package array;

public class PermutationSequence {
    private int[] ns = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    public int getN(int n) {
        return ns[n];
    }

    private int getNth(int k) {
        int n = 1;
        while (k > getN(n)) n++;
        return n;
    }

    private void swap(StringBuilder sb, int i, int j) {
        char c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
    }

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i + 1);
        }

        while (k != 1) {
            int nth = getNth(k);
//            k = k - getN(nth - 1);
            int th = (k - 1) / getN(nth - 1);

            k = (k - 1) % getN(nth - 1) + 1;

            swap(sb, n - nth, n - nth + th);

            for (int i = n - nth + th; i > n - nth + 1; i--) {
                swap(sb, i, i - 1);
            }
        }

        return sb.toString();

    }
}
