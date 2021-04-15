package array;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int from = 0, to = nums.length - 1;
        int mid;

        while (from <= to) {
            mid = from + (to - from) / 2;
            if (nums[mid] == target) return mid;
            if (nums[from] < nums[to]) {
                if (target < nums[mid]) {
                    to = mid - 1;
                } else {
                    from = mid + 1;
                }

            } else if (nums[from] > nums[to]) {
                if (nums[mid] >= nums[from] && target < nums[from])
                    from = mid + 1;
                else if (nums[mid] >= nums[from] && target > nums[from] && target > nums[mid])
                    from = mid + 1;
                else if (nums[mid] < nums[from] && target < nums[from] && target > nums[mid])
                    from = mid + 1;
                else
                    to = mid - 1;
            } else
                from++;
        }
        return -1;

    }
}
