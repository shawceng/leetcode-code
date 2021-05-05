package array;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((m, n) -> m.getValue() - n.getValue());
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            queue.offer(e);
            if (queue.size() == k + 1) {
                queue.poll();
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = queue.poll().getKey();
        }
        return ret;
    }
}
