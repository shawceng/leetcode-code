package array;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutive {
    public int longestConsecutiveSet(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int each :
                nums) {
            map.add(each);
        }
        int longest = 0;
        for (int each :
                nums) {
            if (map.contains(each - 1)) {
                continue;
            }
            int l = 1;
            for (int i = each + 1; map.contains(i); i++, l++) ;

            longest = Math.max(l, longest);
        }
        return longest;
    }

    public int longestConsecutive(int[] nums) {
        int longest = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int each :
                nums) {
            int l = 1;
            if (map.containsKey(each)) continue;
            map.put(each, 1);

            if (map.containsKey(each + 1)) {
                l = mergeCluster(map, each, each + 1);
            }
            if (map.containsKey(each - 1)) {
                l = mergeCluster(map, each - 1, each);
            }
            longest = Math.max(l, longest);
        }
        return longest;
    }

    private int mergeCluster(HashMap<Integer, Integer> map, int from, int to) {
        int upper = to + map.get(to) - 1;
        int lower = from - map.get(from) + 1;
        int length = upper - lower + 1;
        map.put(upper, length);
        map.put(lower, length);
        return length;
    }
}
