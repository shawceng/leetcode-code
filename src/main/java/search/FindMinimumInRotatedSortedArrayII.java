package search;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    int binarySearch(int[] nums, int from, int to) {
        if (from >= to) return nums[from];
        int mid = from + (to - from) / 2;
        if (nums[from] < nums[to]) return nums[from];
        else return Math.min(binarySearch(nums, from, mid), binarySearch(nums, mid + 1, to));
    }
}
