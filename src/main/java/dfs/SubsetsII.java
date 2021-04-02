package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rets = new ArrayList<>();
        Arrays.sort(nums);
        dfs(rets, new Stack<>(), nums, 0);
        return rets;
    }

    void dfs(List<List<Integer>> rets, Stack<Integer> path, int[] nums, int k) {
        rets.add(new ArrayList<>(path));
        for (int i = k; i < nums.length; i++) {
            if (i > k && nums[i] == nums[i - 1]) continue;
            path.push(nums[i]);
            dfs(rets, path, nums, i + 1);
            path.pop();
        }
    }
}
