package enumerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int e :
                nums) {
            res.add(e);
        }
        do {
            result.add(new ArrayList<>(res));
        } while (nextPermute(res));

        return result;
    }

    private boolean nextPermute(List<Integer> nums) {
        int k = nums.size() - 2;

        while (k >= 0 && nums.get(k) >= nums.get(k + 1)) k--;
        if (k < 0) return false;

        int p = nums.size() - 1;
        while (nums.get(p) <= nums.get(k)) p--;
        swap(nums, p, k);

        reverse(nums, k + 1, nums.size());
        return true;
    }

    private void reverse(List<Integer> nums, int from, int to) {
        for (int i = 0; i < (to - from) / 2; i++) {
            swap(nums, from + i, to - i - 1);
        }
    }

    private void swap(List<Integer> nums, int i, int j) {
        int t = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, t);
    }
}
