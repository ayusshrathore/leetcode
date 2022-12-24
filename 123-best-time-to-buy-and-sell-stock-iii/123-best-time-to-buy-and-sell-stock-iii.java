class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for (int[][] row : dp) {
            for (int[] subrow : row) Arrays.fill(subrow, -1);
        }
        return f(0, 1, 2, prices, n, dp);
    }

    public int f(int idx, int buy, int cap, int[] prices, int n, int[][][] dp) {
        if (idx == n || cap == 0) return 0;

        if (dp[idx][buy][cap] != -1) return dp[idx][buy][cap];

        int profit = 0;
        // buy -> 1, notBuy -> 0
        if (buy == 1) {
            int take = -prices[idx] + f(idx + 1, 0, cap, prices, n, dp);
            int notTake = 0 + f(idx + 1, 1, cap, prices, n, dp);
            profit = Math.max(take, notTake);
        } else {
            int sell = prices[idx] + f(idx + 1, 1, cap - 1, prices, n, dp);
            int dontSell = 0 + f(idx + 1, 0, cap, prices, n, dp);
            profit = Math.max(sell, dontSell);
        }
        return dp[idx][buy][cap] = profit;
    }
}