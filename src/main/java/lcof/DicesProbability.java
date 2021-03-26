package lcof;

import java.util.Arrays;

public class DicesProbability {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1 / 6.0);

        for (int i = 1; i < n; i++) {
            double[] tmp = new double[dp.length + 5];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] * (1 / 6.0);
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
