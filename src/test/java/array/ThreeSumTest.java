package array;

public class ThreeSumTest {
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4, -3, 3};
        System.out.println(ts.threeSum(arr));
    }
}
