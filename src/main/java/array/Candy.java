package array;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;

        int l = ratings.length;
        int[] increment = new int[l];
        increment[0] = 1;

        for (int i = 1; i < l; i++) {
            if (ratings[i] > ratings[i - 1]) {
                increment[i] = increment[i - 1] + 1;
            } else {
                increment[i] = 1;
            }
        }

        for (int i = l - 2; i >= 0 ; i--) {
            if (ratings[i] > ratings[i + 1]) {
                increment[i] = Math.max(increment[i + 1] + 1, increment[i]);
            }
        }

        int sum = 0;
        for (int each:
             increment) {
            sum += each;
        }
        return sum;

    }

    public int candy_(int[] ratings) {
        if (ratings.length == 0) return 0;
        int[] f = new int[ratings.length];

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += solve(ratings, f, i);
        }
        return sum;
    }

    private int solve(int[] ratings, int[] f, int i) {
        if (f[i] == 0) {
            f[i] = 1;
            if (i > 0 && ratings[i] > ratings[i - 1])
                f[i] = Math.max(f[i], solve(ratings, f, i - 1) + 1);
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1])
                f[i] = Math.max(f[i], solve(ratings, f, i + 1) + 1);
        }
        return f[i];
    }
}
