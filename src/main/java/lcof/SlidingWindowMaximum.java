package lcof;

import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] ret = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int to = 0, from = 1 - k; to < nums.length; to++, from++) {
            if (from > 0 && deque.peekFirst() < from) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[to]) {
                deque.pollLast();
            }

            deque.offerLast(to);
            if (from >= 0) ret[from] = nums[deque.peekFirst()];
        }
        return ret;
    }
}
