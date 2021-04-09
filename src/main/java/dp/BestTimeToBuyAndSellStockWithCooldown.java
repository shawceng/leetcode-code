package dp;

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length + 2];
        int minDay = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minDay]) {
                minDay = i;
            }
            dp[i + 2] = Math.max(dp[i + 1], prices[i] - prices[minDay] + dp[minDay]);
        }
        return dp[dp.length - 1];
    }
}
