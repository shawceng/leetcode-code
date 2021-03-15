package linkedList;

import java.util.*;

public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        int v = map.remove(key);
        map.put(key, v);
        return v;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            get(key);
        } else {
            if (map.size() == capacity) {
                map.remove(map.entrySet().iterator().next().getKey());
            }
            map.put(key, value);
        }
    }
}
