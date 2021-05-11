package search;

import java.util.Arrays;

public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int up = Arrays.stream(bloomDay).max().getAsInt();
        while (low < up) {
            int mid = (low + up) >> 1;
            if (isSuccess(bloomDay, m, k, mid)) {
                up = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean isSuccess(int[] bloomDay, int m, int k, int val) {
        int from = -1, to;
        int r = 0;
        for (to = 0; to < bloomDay.length && r < m; to++) {
            if (bloomDay[to] > val) {
                from = to;
            }
            if (to - from == k) {
                from = to;
                r++;
            }
        }
        return r == m;
    }
}
