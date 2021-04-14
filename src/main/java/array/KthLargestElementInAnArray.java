package array;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int from = 0, to = nums.length - 1;
        k = k - 1;
        while (from < to) {
            int mid = partition(nums, from, to);
            if (mid > k) {
                to = mid - 1;
            } else if (mid < k) {
                from = mid + 1;
            } else {
                return nums[k];
            }
        }
        return nums[from];
    }

    int partition(int[] nums, int from, int to) {
        int rdm = from + (to - from) / 2;
        int pivot = nums[rdm];
        swap(nums, rdm, from);
        int start = from;
        while (from < to) {
            while (from < to && nums[to] < pivot) to--;
            while (from < to && nums[from] >= pivot) from++;
            if (from < to) {
                swap(nums, from, to);
            }
        }
        swap(nums, start, from);
        return from;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
