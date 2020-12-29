package string;

public class WordsReverse {
public void reverse(char[] s, int from, int to) {
    while(from < to) {
        char c = s[from];
        s[from ++] = s[to - 1];
        s[--to] = c;
    }
}

public String wordsReverse(String s) {
    char str[] = s.toCharArray();
    int from = 0;
    int to = 0;
    while(to < str.length) {
        if (str[to] == ' ') {
            reverse(str, from, to);
            from = to + 1;
        }
        to ++;
    }
    reverse(str, from, to);
    reverse(str, 0, str.length);
    return String.valueOf(str);
}
}
