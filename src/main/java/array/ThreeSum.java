package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list;

        Arrays.sort(nums);
        int from = 0, to;
        int target = 0;

        while (from < nums.length - 2) {
            to = nums.length - 1;
            int i = from + 1;
            if (nums[from] > 0) break;
            while (i < to) {
                if (nums[i] + nums[from] + nums[to] == target) {
                    list.add(Arrays.asList(nums[from], nums[i], nums[to]));
                    while (from < to - 1 && nums[--to] == nums[to + 1]) ;
                    while (i < to && nums[++i] == nums[i - 1]) ;
                } else if (nums[i] + nums[from] + nums[to] <= target) {
                    while (i < to && nums[++i] == nums[i - 1]) ;
                } else {
                    while (from < to - 1 && nums[--to] == nums[to + 1]) ;
                }
            }
            while (from < nums.length - 2 && nums[++from] == nums[from - 1]) ;
        }
        return list;
    }
}
