package enumerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        subsets(result, new ArrayList<>(), nums, 0, nums.length);
        return result;
    }

    private void subsets(List<List<Integer>> result, List<Integer> res, int[] nums, int k, int len) {
        if (k == len) {
            result.add(res);
            return;
        }
        if (res.size() < 1 || res.get(res.size() - 1) != nums[k])
            subsets(result, res, nums, k + 1, len);

        List<Integer> newRes = new ArrayList<>(res);
        newRes.add(nums[k]);
        subsets(result, newRes, nums, k + 1, len);
    }
}
