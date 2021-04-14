package dp;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int ret = 1;
        for (int i = 1; i < nums.length; i++) {
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                } else if (nums[i] == nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] - 1);
                    break;
                }
            }
            dp[i]++;
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
