package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap();
        int cur = 0;
        for (List<Integer> each : wall) {
            cur = 0;
            for (Integer x : each) {
                cur += x;
                int t = map.getOrDefault(cur, wall.size());
                map.put(cur, t - 1);
            }
        }
        map.put(cur, wall.size());
        int ret = wall.size();
        for (Integer e : map.values()) {
            ret = Math.min(e, ret);
        }
        return ret;
    }
}
