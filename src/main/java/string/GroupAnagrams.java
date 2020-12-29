package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String each:
             strs) {
            char t[] = each.toCharArray();
            Arrays.sort(t);
            String s = String.valueOf(t);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(each);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key:
             map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}
