package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combine(candidates, result, new Stack<>(), target, 0);
        return result;
    }

    private void combine(int[] candidates, List<List<Integer>> result, Stack<Integer> path, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            path.push(candidates[i]);
            combine(candidates, result, path, target - candidates[i], i + 1);
            path.pop();
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++;
        }
    }
}
