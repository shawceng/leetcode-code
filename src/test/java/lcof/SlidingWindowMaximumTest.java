package lcof;

public class SlidingWindowMaximumTest {
    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] r = swm.maxSlidingWindow(new int[]{2,}, 1);
        for (int e :
                r) {
            System.out.println(e);
        }
    }
}
