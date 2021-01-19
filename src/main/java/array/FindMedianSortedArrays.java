package array;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if ((total & 0x1) == 1)
            return findKth(nums1, 0, nums2, 0, total / 2);
        else
            return ((double) findKth(nums1, 0, nums2, 0, total / 2) +
                + findKth(nums1, 0, nums2, 0, total / 2 - 1)) / 2;
    }

    public static int findKth(int[] A, int m, int[] B, int n, int k) {
        int alen = A.length - m, blen = B.length - n;
        if (alen < blen) return findKth(B, n, A, m, k);
        if (blen == 0) return A[m + k];
        if (k == 0) return Math.min(A[m], B[n]);

        int ib = Math.min(blen, k / 2 + 1), ia = k - ib + 1;
        if (A[m + ia - 1] > B[n + ib - 1]) {
            return findKth(A, m, B, n + ib, k - ib);
        } else if (A[m + ia - 1] < B[n + ib - 1])
            return findKth(A, m + ia, B, n, k - ia);
        else return A[m + ia - 1];
    }
}
