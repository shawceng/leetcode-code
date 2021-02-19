package enumerate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        subsets(result, new ArrayList<>(), nums, 0, nums.length);
        return result;
    }

    private void subsets(List<List<Integer>> result, List<Integer> res, int[] nums, int k, int len) {
        if (k == len) {
            result.add(res);
            return;
        }
        subsets(result, res, nums, k + 1, len);

        List<Integer> newRes = new ArrayList<>(res);
        newRes.add(nums[k]);
        subsets(result, newRes, nums, k + 1, len);
    }
}
