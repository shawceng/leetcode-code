package array;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(val)) {
                return new int[]{map.get(val), i};
            }
            map.put(target - val, i);
        }
        return new int[0];
    }
}
