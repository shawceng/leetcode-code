package lcof;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    /**
     * initialize your data structure here.
     */
    private Queue<Integer> big, little;

    public MedianFinder() {
        big = new PriorityQueue<>(((a, b) -> (b - a)));
        little = new PriorityQueue<>();
    }

    public void addNum(int num) {
        big.offer(num);
        little.offer(big.poll());
        if (little.size() - 1 > big.size()) {
            big.offer(little.poll());
        }
    }

    public double findMedian() {
        if (little.size() != big.size()) return little.peek();
        else return (little.peek() + big.peek()) / 2.0;
    }
}
