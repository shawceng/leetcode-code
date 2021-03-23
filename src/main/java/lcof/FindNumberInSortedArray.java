package lcof;

public class FindNumberInSortedArray {
    public int search(int[] nums, int target) {
        int from = 0, to = nums.length;
        int mid = 0;
        while (from < to) {
            mid = from + (to - from) / 2;
            if (nums[mid] > target) {
                to = mid;
            } else if (nums[mid] < target) {
                from = mid + 1;
            } else {
                break;
            }
        }
        if (nums[mid] != target) return 0;

        int t = mid;
        int mid2;
        while (from < t) {
            mid2 = from + (t - from) / 2;
            if (nums[mid2] < target) {
                from = mid2 + 1;
            } else {
                t = mid2;
            }
        }
        t = mid;
        while (t < to) {
            mid2 = t + (to - t) / 2;
            if (nums[mid2] > target) {
                to = mid2;
            } else {
                t = mid2 + 1;
            }
        }
        return to - from;
    }
}
