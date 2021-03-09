package detail;

import java.util.ArrayList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] interval:
             intervals) {
            int left = interval[0];
            int right = interval[1];
            boolean placed = false;
            ArrayList<int[]> t = new ArrayList<>();
            for (int[] e:
                 list) {
                if (left > e[1]) {
                    t.add(e);
                } else if (right < e[0]) {
                    if (!placed) {
                        t.add(new int[]{left, right});
                        placed = true;
                    }
                    t.add(e);
                } else {
                    left = Math.min(left, e[0]);
                    right = Math.max(right, e[1]);
                }
            }
            if (!placed) {
                t.add(new int[]{left, right});
            }
            list = t;
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
