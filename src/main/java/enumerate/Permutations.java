package enumerate;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int e :
                nums) {
            res.add(e);
        }
        dfs(result, res, 0, nums.length);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> res, int k, int len) {
        if (k == len) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int i = k; i < len; i++) {
            swap(res, k, i);
            dfs(result, res, k + 1, len);
            swap(res, i, k);
        }

    }

    private void swap(List<Integer> list, int i, int j) {
        int t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }
}
