package dp;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        int[] lefts = new int[len];
        int[] rights = new int[len];

        for (int i = 1, valley = prices[0]; i < len; i++) {
            valley = Math.min(valley, prices[i - 1]);
            lefts[i] = Math.max(lefts[i - 1], prices[i] - valley);
        }

        for (int i = len - 2, peak = prices[len - 1]; i >= 0; i--) {
            peak = Math.max(peak, prices[i + 1]);
            rights[i] = Math.max(rights[i + 1], peak - prices[i]);
        }

        int ret = 0;
        for (int i = 0; i < len; i++) {
            ret = Math.max(ret, lefts[i] + rights[i]);
        }

        return ret;
    }
}
