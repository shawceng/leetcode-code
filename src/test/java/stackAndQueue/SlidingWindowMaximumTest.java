package stackAndQueue;

public class SlidingWindowMaximumTest {
    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] res = swm.maxSlidingWindow(new int[]{1, 5, 1, 7, 32, 7, 222, 87, 2, 3, 5, 7, 2, 4, 9, 2}, 3);
        for (int t : res) {
            System.out.println(t);
        }
    }
}
