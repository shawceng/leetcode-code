package string;

import com.sun.jdi.ArrayReference;

import java.util.*;

public class Permutation {
    public String[] permutation(String s) {
        List<String> result = new ArrayList<>();
        if (s.isEmpty()) return result.toArray(new String[result.size()]);

        dfs(result, s.toCharArray(), new char[s.length()], 0);

        return result.toArray(new String[result.size()]);
    }

    public void dfs(List<String> result, char[] chars, char[] res, int from) {
        if (from >= chars.length) {
            result.add(String.valueOf(res));
            return;
        }
        char c = chars[from];
        HashSet<Character> set = new HashSet<Character>();
        for (int i = from; i < chars.length; i++) {
            char t = chars[i];
            if (set.contains(t)) continue;
            set.add(t);

            chars[i] = c;
            res[from] = t;
            dfs(result, chars, res, from + 1);
            chars[i] = t;
        }
    }

    public String[] permutationDict(String s) {
        List<String> result = new ArrayList<>();
        if (s.isEmpty()) return result.toArray(new String[result.size()]);

        char chars[] = s.toCharArray();
        Arrays.sort(chars);
        result.add(String.valueOf(chars));
        nextPermutation(result, chars);
        return result.toArray(new String[result.size()]);
    }

    public void nextPermutation(List<String> result, char[] chars) {
        int i, j;
        for (i = chars.length - 2; (i >= 0) && (chars[i] >= chars[i + 1]); i--);

        if (i == -1) return;

        for (j = chars.length - 1; (j > i) && (chars[j] <= chars[i]); j--);

        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;

        reverse(chars, i + 1, chars.length);
        result.add(String.valueOf(chars));

        nextPermutation(result, chars);
    }

    public void reverse(char[] chars, int from, int to) {
        if (from >= to - 1) return;
        // 0 1 2 3 4 5 6
        for (int i = from; i < (from + to) / 2; i++) {
            char t = chars[i];
            chars[i] = chars[to - i + from - 1];
            chars[to - i + from - 1] = t;
        }
    }
}
