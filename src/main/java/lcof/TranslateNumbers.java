package lcof;

import java.util.Stack;

public class TranslateNumbers {
    public int translateNum(int num) {
        return dfs(String.valueOf(num), 0);

    }

    private int dfs(String num, int level) {
        if (level >= num.length() - 1) {
            return 1;
        }
        int ret = 0;
        if (num.charAt(level) ==  '1'
                || (num.charAt(level) == '2'
                && level + 1 < num.length()
                && num.charAt(level + 1) < '6')) {
            ret += dfs(num, level + 2);

        }
        return dfs(num, level + 1) + ret;
    }
}
