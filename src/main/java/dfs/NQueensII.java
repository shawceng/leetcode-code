package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NQueensII {
    public int totalNQueens(int n) {
        int[] queens = new int[n + 1];
        return nQueens(queens, 0, n);
    }

    private int nQueens(int[] queens, int level, int n) {
        if (level == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int queen = 1 << i;
            if (isVaild(queens, queen, level)) {
                queens[level] = queen;
                queens[n] += queen;
                count += nQueens(queens, level + 1, n);
                queens[n] -= queen;
            }
        }
        return count;
    }

    private boolean isVaild(int[] queens, int queen, int level) {
        if (queens[queens.length - 1] > (queens[queens.length - 1] ^ queen)) return false;
        for (int i = 1; i <= level; i++) {
            if (queen == (queens[level - i] << i) || queen == (queens[level - i] >> i)) return false;
        }
        return true;
    }
}
