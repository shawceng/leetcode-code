package lcof;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int from = 0, to = nums.length - 1;
        while (from < to) {
            int v = nums[from] + nums[to];
            if (v < target) {
                from++;
            } else if (v > target) {
                to--;
            } else {
                return new int[]{nums[from], nums[to]};
            }
        }
        return new int[0];
    }
}
