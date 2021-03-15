package detail;

import java.util.HashMap;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points.length < 2) return points.length;
        HashMap<Double, Integer> map;
        int ret = 0;
        for (int i = 0; i < points.length; i++) {
            map = new HashMap<>();
            int[] p1 = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int[] p2 = points[j];
                double k = Double.MAX_VALUE;
                if (p1[1] != p2[1])
                    k = ((double) p1[0] - p2[0]) / (p1[1] - p2[1]);
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
            for (int v:
                 map.values()) {
                ret = Math.max(ret, v + 1);
            }
        }
        return ret;
    }
}
