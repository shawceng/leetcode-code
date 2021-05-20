package dp;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    int MOD = (int)Math.pow(10, 9) + 7;
    public int numWays(int steps, int arrLen) {
        int maxStep = Math.min(arrLen, steps / 2 + 1);
        int[] dp = new int[maxStep + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < steps; i++) {
            int pre = dp[0];
            dp[0] = (dp[0] + dp[1]) % MOD;
            for (int j = 1; j < maxStep && pre != 0; j++) {
                int t = dp[j];
                dp[j] = (pre + dp[j]) % MOD;
                dp[j] = (dp[j] + dp[j + 1]) % MOD;
                pre = t;
            }
        }
        return dp[0];
    }
}
