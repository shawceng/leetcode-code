package detail;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> ret = new ArrayList<>();

        int from = 0;
        int len = 0;

        for (int i = 0; i < words.length; i++) {
            if (len + words[i].length() + i - from > maxWidth) {
                combine(ret, words, from, i, len, maxWidth);
                from = i;
                len = 0;
            }
            len += words[i].length();
        }
        combineLastest(ret, words, from, words.length, len, maxWidth);
        return ret;
    }

    private void combine(List<String> ret, String[] words, int from, int to, int len, int maxWidth) {
        StringBuilder path = new StringBuilder();
        int count = to - from - 1;
        int space = maxWidth - len;
        int eachSpace = count > 0 ? space / count : space;
        int remainSpace = count > 0 ? space % count : 0;
        for (int i = from; i < to; i++) {
            path.append(words[i]);
            int addSpaces = space > 0 ? eachSpace : 0;
            if (remainSpace > 0) {
                remainSpace--;
                addSpaces++;
            }
            space -= addSpaces;
            path.append(" ".repeat(addSpaces));
        }
        ret.add(path.toString());
    }

    private void combineLastest(List<String> ret, String[] words, int from, int to, int len, int maxWidth) {
        StringBuilder path = new StringBuilder();
        int space = maxWidth - len;
        for (int i = from; i < to; i++) {
            path.append(words[i]);
            if (space > 0) {
                path.append(" ");
                space--;
            }
        }
        if (space > 0) path.append(" ".repeat(space));
        ret.add(path.toString());
    }
}
