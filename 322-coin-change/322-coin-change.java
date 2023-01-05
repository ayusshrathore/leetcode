class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        for (int[] rows : dp) Arrays.fill(rows, -1);
        
        int ans = f(n - 1, coins, amount, dp);
        if (ans > amount) return -1;
        return ans;
    }
    
    private int f(int idx, int[] coins, int T, int[][] dp) {
        if (idx == 0) {
            if (T % coins[idx] == 0) return T/coins[idx];
            else return 10001;
        }
        if (dp[idx][T] != -1) return dp[idx][T];
        
        int notTake = 0 + f(idx - 1, coins, T, dp);
        int take = Integer.MAX_VALUE;
        if (coins[idx] <= T) take = 1 + f(idx, coins, T - coins[idx], dp);
        
        return dp[idx][T] = Math.min(take, notTake);
    }
}