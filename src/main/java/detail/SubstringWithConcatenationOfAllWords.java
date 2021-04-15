package detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if (s.isEmpty()) return ret;

        HashMap<String, Integer> ori = new HashMap<>();
        for (String e :
                words) {
            ori.put(e, ori.getOrDefault(e, 0) + 1);
        }

        int oneWord = words[0].length();
        int allWord = oneWord * words.length;

        for (int i = 0; i < oneWord; i++) {
            int count = 0;
            HashMap<String, Integer> tmp = new HashMap<>();
            int l = i, r = i + allWord;
            int cur = i + oneWord;
            while (r <= s.length() && cur <= s.length()) {
                String t = s.substring(cur - oneWord, cur);
                if (ori.containsKey(t)) {
                    int val = tmp.getOrDefault(t, 0);
                    if (val == ori.get(t)) {
                        String t1 = s.substring(l, l + oneWord);
                        if (tmp.get(t1) == ori.get(t1))
                            count--;
                        tmp.put(t1, tmp.get(t1) - 1);
                        l += oneWord;
                        r += oneWord;
                        continue;
                    }
                    if (val + 1 == ori.get(t))
                        count++;
                    tmp.put(t, val + 1);
                } else {
                    l = cur;
                    r = cur + allWord;
                    count = 0;
                    tmp.clear();
                }
                if (count == ori.size())
                    ret.add(l);
                cur += oneWord;
            }
        }
        return ret;
    }
}
