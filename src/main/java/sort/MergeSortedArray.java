package sort;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) {
            if (m == 0 || nums1[m - 1] < nums2[n - 1]) {
                nums1[m + n - 1] = nums2[--n];
            } else {
                nums1[m + n - 1] = nums1[--m];
            }
        }
    }
}
