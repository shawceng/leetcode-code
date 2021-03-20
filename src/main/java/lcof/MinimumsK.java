package lcof;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumsK {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int e :
                arr) {
            if (queue.size() == k) {
                if (queue.peek() > e) {
                    queue.poll();
                } else {
                    continue;
                }
            }
            queue.offer(e);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
