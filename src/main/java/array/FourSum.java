package array;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> result = new HashSet<>();
        if (nums.length < 4) return new ArrayList<>();

        Arrays.sort(nums);
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();

        int a = 0, b;
        while (a < nums.length - 3) {
            b = a + 1;
            while (b < nums.length - 2) {
                int key = nums[a] + nums[b];
                if (!map.containsKey(key))
                    map.put(key, new ArrayList<>());
                map.get(key).add(Arrays.asList(a, b));
                while (b < nums.length - 2 && nums[++b] == nums[b - 1]);
            }
            while (a < nums.length - 3 && nums[++a] == nums[a - 1]);
        }

        int c = 2, d;
        while (c < nums.length - 1) {
            d = c + 1;
            while (d < nums.length) {
                int key = target - (nums[c] + nums[d]);
                if (map.containsKey(key)) {
                    for (List<Integer> each:
                         map.get(key)) {
                        if (each.get(1) >= c)
                            continue;
                        result.add(Arrays.asList(
                                nums[each.get(0)],
                                nums[each.get(1)],
                                nums[c],
                                nums[d]
                        ));
                    }
                }
                d++;
                while (d < nums.length && nums[d] == nums[d - 1]) d++;
            }
            c++;
        }

        return new ArrayList<>(result);
    }
}
