package dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        dfs(result, path, n, 0, 0);
        return result;
    }

    private void dfs(List<String> result, StringBuilder path, int n, int used, int closed) {
        if (n == used && closed == n) {
            result.add(path.toString());
            return;
        }

        int k = path.length();
        char c = used > 0 ? path.charAt(k - 1) : 0;
        if (c != ')')
            for (int i = closed + 1; i <= used; i++) {
                path.append(")".repeat(i - closed));
                dfs(result, path, n, used, i);
                path.delete(k, path.length());
            }

        if (c != '(')
            for (int i = used + 1; i <= n; i++) {
                path.append("(".repeat(i - used));
                dfs(result, path, n, i, closed);
                path.delete(k, path.length());
            }
    }
}
