package sort;

public class MergeSortedArrayTest {
    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int[] arr = {1, 2, 9, 0, 0, 0};
        msa.merge(arr, 3, new int[]{2,5,6}, 3);
        for (int each:
             arr) {
            System.out.println(each);
        }
    }
}
