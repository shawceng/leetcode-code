package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning {
    public List<List<String>> partitionDp(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = i >= j - 1 || (dp[i + 1][j - 1]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        Stack<String> path = new Stack<>();

        dpDfs(result, path, dp, s, 0, len);
        return result;
    }

    private void dpDfs(List<List<String>> result, Stack<String> path, boolean[][] dp, String s, int start, int len) {
        if (start == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (dp[start][i]) {
                path.push(s.substring(start, i + 1));
                dpDfs(result, path, dp, s, i + 1, len);
                path.pop();
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new Stack<String>(), s, 0);
        return result;
    }

    private void dfs(List<List<String>> result, Stack<String> path, String s, int from) {
        if (from == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = from + 1; i <= s.length(); i++) {
            if (isPalindrome(s, from, i)) {
                path.push(s.substring(from, i));
                dfs(result, path, s, i);
                path.pop();
            }
        }

    }

    private boolean isPalindrome(String s, int from, int to) {
        while (from < to) {
            if (s.charAt(from--) != s.charAt(--to))
                return false;
        }
        return true;
    }
}
