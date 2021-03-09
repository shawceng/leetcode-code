package detail;

import java.util.ArrayList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        ArrayList<int[]> list = new ArrayList<>();
        boolean placed = false;
        for (int[] e:
             intervals) {
            if (e[1] < left) {
                list.add(e);
            } else if (e[0] > right) {
                if (!placed) {
                    list.add(new int[]{left, right});
                    placed = true;
                }
                list.add(e);
            } else {
                left = Math.min(left, e[0]);
                right = Math.max(right, e[1]);
            }
        }
        if (!placed) {
            list.add(new int[]{left, right});
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
