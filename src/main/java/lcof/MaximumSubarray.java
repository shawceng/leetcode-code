package lcof;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        for (int i = 1, cur = nums[0]; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            max = Math.max(cur, max);
        }
        return max;
    }
}
