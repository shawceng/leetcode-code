package lcof;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        int[] copy = new int[nums.length];
        return mergeCount(nums, 0, nums.length, copy);
    }

    int mergeCount(int[] nums, int from, int to, int[] copy) {
        if (from >= to - 1) return 0;
        int mid = from + (to - from) / 2;
        int ret = mergeCount(nums, from, mid, copy) + mergeCount(nums, mid, to, copy);

        int lptr = from, rptr = mid;
        int cnt = 0;
        int i = from;
        while (lptr < mid) {
            if (rptr == to || nums[lptr] <= nums[rptr]) {
                copy[i++] = nums[lptr++];
                cnt += rptr - mid;
            } else {
                copy[i++] = nums[rptr++];
            }
        }
        for (int j = from; j < i; j++) {
            nums[from + j] = copy[j];
        }
        return ret + cnt;
    }
}
