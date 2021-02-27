package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        dfs(result, new Stack<String>(), s, 0);
        return result;
    }

    private void dfs(List<String> result, Stack<String> path, String s, int start) {
        if (start == s.length()) {
            if (path.size() == 4)
                result.add(String.join(".", path));
            return;
        }
        if (s.length() - start > (4 - path.size()) * 3) return;
        if (s.length() - start < (4 - path.size())) return;

        int num = 0;
        for (int i = 0; i < 3 && start + i < s.length(); i++) {
            num = num * 10 + s.charAt(start + i) - '0';
            if (num > 255) break;
            path.push(String.valueOf(num));
            dfs(result, path, s, start + i + 1);
            path.pop();
            if (num == 0) return;
        }
    }
}
