package array;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int from = 0, to = nums.length - 1;
        while (from < to) {
            int mid = from + (to - from) / 2;
            if (mid < nums[mid]) to = mid - 1;
            else from = mid + 1;
        }
        if (from == nums.length - 1 && nums[from] == from) return from + 1;
        return from;
    }
}
