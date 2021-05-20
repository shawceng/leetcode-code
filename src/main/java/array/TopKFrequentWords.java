package array;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words);

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> items = new PriorityQueue<>(
                (Map.Entry<String, Integer> a, Map.Entry<String, Integer> b)
                    ->
                    a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue().compareTo(b.getValue())
                );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            items.offer(entry);
            if (items.size() > k) {
                items.poll();
            }
        }

        List<String> ret = new ArrayList<>();
        while (!items.isEmpty()) {
            ret.add(items.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }
}
