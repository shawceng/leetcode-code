package search;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int from = 0, to = nums.length - 1;
        while (from < to) {
            int mid = from + (to - from) / 2;
            if (nums[mid] >= nums[from]) {
                if (nums[mid] > nums[to]) {
                    from = mid + 1;
                } else {
                    to = mid - 1;
                }
            } else {
                to = mid;
            }
        }
        return nums[from];
    }
}
