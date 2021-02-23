package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n + 1];
        nQueens(result, new Stack<String>(), queens, 0, n);
        return result;
    }

    private void nQueens(List<List<String>> result, Stack<String> path, int[] queens, int level, int n) {
        if (level == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            int queen = 1 << i;
            if (isVaild(queens, queen, level)) {
                path.push(".".repeat(i) + "Q" + ".".repeat(n - i - 1));
                queens[level] = queen;
                queens[n] += queen;
                nQueens(result, path, queens, level + 1, n);
                queens[n] -= queen;
                path.pop();
            }
        }
    }

    private boolean isVaild(int[] queens, int queen, int level) {
        if (queens[queens.length - 1] > (queens[queens.length - 1] ^ queen)) return false;
        for (int i = 1; i <= level; i++) {
            if (queen == (queens[level - i] << i) || queen == (queens[level - i] >> i)) return false;
        }
        return true;
    }
}
