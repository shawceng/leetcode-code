package dp;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int cur = 0;
        for (int e :
                nums) {
            cur = Math.max(e, cur + e);
            result = Math.max(result, cur);
        }
        return result;
    }
}
