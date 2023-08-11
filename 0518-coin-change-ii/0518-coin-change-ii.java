class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        for (int[] rows : dp) Arrays.fill(rows, -1);
        
        return f(n - 1, coins, amount, dp);
    }
    
    private int f(int idx, int[] coins, int T, int[][] dp) {
        if (idx == 0) {
            if (T % coins[idx] == 0) return 1;
            return 0;
        }
        if (dp[idx][T] != -1) return dp[idx][T];
        
        int notTake = f(idx - 1, coins, T, dp);
        int take = 0;
        if (coins[idx] <= T) take = f(idx, coins, T - coins[idx], dp);
        
        return dp[idx][T] = take + notTake;
    }
}