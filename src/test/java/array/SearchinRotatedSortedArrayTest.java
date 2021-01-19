package array;

public class SearchinRotatedSortedArrayTest {
    public static void main(String[] args) {
        SearchinRotatedSortedArray srsa = new SearchinRotatedSortedArray();
        int[] arr = new int[]{0, 0, 1, 1, 2, 0};
        int res = srsa.search(arr, 2);
        System.out.println(res);
    }
}
