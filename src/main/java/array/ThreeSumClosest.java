package array;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int from = 0, to;
        int i, t, result = Integer.MAX_VALUE;
        while (from < nums.length - 2) {
            to = nums.length - 1;
            i = from + 1;
            while (i < to) {
                t = nums[from] + nums[i] + nums[to];
                if (t < target)
                    while (i < to && nums[++i] == nums[i - 1]) ;
                else if (t == target)
                    return target;
                else
                    while (i < to && nums[--to] == nums[to + 1]) ;
                if (Math.abs(target - result) > Math.abs(t - target)) {
                    result = t;
                }
            }
            while (from < nums.length - 2 && nums[++from] == nums[from - 1]) ;
        }
        return result;
    }
}
