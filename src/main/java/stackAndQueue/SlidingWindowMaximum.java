package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] rets = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            dq.offerLast(i);
            if (dq.peekFirst() == i - k) dq.pollFirst();
            if (i >= k - 1)
                rets[i - k + 1] = nums[dq.peekFirst()];
        }
        return rets;
    }
}
