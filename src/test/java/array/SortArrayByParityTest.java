package array;

public class SortArrayByParityTest {
    public static void main(String[] args) {
        SortArrayByParity sabp = new SortArrayByParity();
        int[] arr = new int[]{1, 5, 4, 6, 7, 9, 2};
        sabp.sortArrayByParity(arr);
        for (int each:
             arr) {
            System.out.println(each);

        }
    }
}
