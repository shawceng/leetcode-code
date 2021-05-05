package search;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            int i = 0, d = 0;
            for (int cur = 0; i < weights.length && d < D; i++) {
                if (cur + weights[i] > mid) {
                    d++;
                    cur = 0;
                }
                cur += weights[i];
            }
            if (d < D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
