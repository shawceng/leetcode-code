package string;

public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        char str[] = s.toCharArray();
        int l = str.length;
        while (n > 0) {
            char t = str[0];
            for (int i = 0; i < l - 1; i++) {
                str[i] = str[i + 1];
            }
            str[l - 1] = t;
            n--;
        }
        return String.valueOf(str);
    }

    void reverse(char[] str, int from, int to) {
        if (to - from <= 1) return;
        for (int i = 0; i < (to - from) / 2; i++) {
            char c = str[from + i];
            str[from + i] = str[to - i - 1];
            str[to - i - 1] = c;
        }
    }

    public String reverseLeftWords2(String s, int n) {

        char str[] = s.toCharArray();
        int l = str.length;
        reverse(str, 0, n);
        reverse(str, n, l);
        reverse(str, 0, l);
        return String.valueOf(str);

    }
}
