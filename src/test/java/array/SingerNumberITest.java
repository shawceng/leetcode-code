package array;

public class SingerNumberITest {
    public static void main(String[] args) {
        SingleNumberI sn = new SingleNumberI();
        int[] arr = {99, 99, 99, 98, 5, 5, 5, 3, 3, 3};
        System.out.println(sn.singleNumber(arr));
    }
}
