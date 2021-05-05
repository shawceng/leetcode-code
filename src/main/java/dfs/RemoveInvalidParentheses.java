package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    int deleted;
    Set<String> res;
    StringBuilder path;

    public List<String> removeInvalidParentheses(String s) {
        deleted = s.length();
        res = new HashSet<>();
        path = new StringBuilder();
        dfs(s, 0, 0, 0);

        return new ArrayList<>(res);
    }

    void dfs(String s, int idx, int left, int deleted) {
        if (left < 0 || deleted > this.deleted) return;
        if (idx == s.length()) {
            if (left != 0) return;
            if (deleted < this.deleted) {
                this.deleted = deleted;
                res.clear();
            }
            res.add(path.toString());
            return;
        }
        char c = s.charAt(idx);
        if (c == ')') {
            dfs(s, idx + 1, left, deleted + 1);
            path.append(')');
            dfs(s, idx + 1, left - 1, deleted);
        } else if (c == '(') {
            dfs(s, idx + 1, left, deleted + 1);
            path.append('(');
            dfs(s, idx + 1, left + 1, deleted);
        } else {
            path.append(c);
            dfs(s, idx + 1, left, deleted);
        }
        path.deleteCharAt(path.length() - 1);
    }

}
