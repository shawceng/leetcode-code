package linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {
    private int capacity, cur;
    private LinkedList<Integer> list;
    private HashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cur = 0;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!list.contains(key)) return -1;

        list.remove((Integer) key);
        list.addLast(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (list.contains(key)) {
            map.put(key, value);
            get(key);
        } else {
            if (cur == capacity) {
                map.remove(list.getFirst());
                list.removeFirst();
                cur--;
            }
            list.addLast(key);
            map.put(key, value);
            cur++;
        }
    }
}
