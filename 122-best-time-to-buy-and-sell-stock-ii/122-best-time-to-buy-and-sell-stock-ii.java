class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return f(0, 1, prices, n, dp);
    }

    private int f(int idx, int buy, int[] prices, int n, int[][] dp) {
        if (idx == n) return 0;

        if (dp[idx][buy] != -1) return dp[idx][buy];

        int profit = Integer.MIN_VALUE;
        // buy -> 1, notBuy -> 0
        if (buy == 1) {
            int take = -prices[idx] + f(idx + 1, 0, prices, n, dp);
            int notTake = 0 + f(idx +1, 1, prices, n, dp);
            profit = Math.max(take, notTake);
        } else {
            int sell = prices[idx] + f(idx + 1, 1, prices, n, dp);
            int dontSell = 0 + f(idx + 1, 0, prices, n, dp);
            profit = Math.max(sell, dontSell);
        }
        return dp[idx][buy] = profit;
    }
}