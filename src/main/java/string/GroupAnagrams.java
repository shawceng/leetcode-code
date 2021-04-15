package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String each :
                strs) {
            char t[] = each.toCharArray();
            Arrays.sort(t);
            String s = String.valueOf(t);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(each);
            map.put(s, list);
        }

        return new ArrayList<>(map.values());
    }
}
