package lcof;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int from = 1, to = 2;
        int sum = 3;
        while (from < to) {
            while (sum < target) {
                sum += ++to;
            }
            while (sum > target) {
                sum -= from++;
            }
            if (sum == target) {
                int[] r = new int[to - from + 1];
                for (int i = from; i <= to; i++) {
                    r[i - from] = i;
                }
                res.add(r);
                sum -= from++;
            }
        }
       return res.toArray(new int[res.size()][]);
    }
}
