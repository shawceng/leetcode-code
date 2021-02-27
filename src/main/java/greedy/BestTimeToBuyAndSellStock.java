package greedy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cur = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (cur > prices[i]) {
                cur = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - cur);
            }
        }
        return profit;
    }
}
