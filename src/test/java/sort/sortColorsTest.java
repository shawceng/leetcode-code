package sort;

public class sortColorsTest {
    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] arr = new int[]{2, 0};
        sc.sortColors(arr);
        for (int each :
                arr) {
            System.out.println(each);

        }
    }
}
