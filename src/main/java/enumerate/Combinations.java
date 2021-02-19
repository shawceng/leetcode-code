package enumerate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        dfs(result, path, 1, n, k);
        return result;
    }

    private void dfs(List<List<Integer>> result, Stack<Integer> path, int from, int to, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (to - from < k - 1) return;
        dfs(result, path, from + 1, to, k);

        path.push(from);
        dfs(result, path, from + 1, to, k - 1);
        path.pop();
    }
}
