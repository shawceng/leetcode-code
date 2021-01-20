package array;

public class FourSumTest {
    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] arr = new int[]{1, 0, -1, 0, -2, 2, 0, 0};
        System.out.println(fourSum.fourSum(arr, 0));
    }
}
