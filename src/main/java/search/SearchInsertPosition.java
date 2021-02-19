package search;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int from = 0, to = nums.length;
        int mid;
        while (from < to) {
            mid = from + ((to - from) >> 1);
            if (nums[mid] > target)
                to = mid;
            else if (nums[mid] < target)
                from = mid + 1;
            else
                return mid;
        }
        return from;
    }
}
