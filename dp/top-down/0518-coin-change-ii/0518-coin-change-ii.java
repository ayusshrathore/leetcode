class Solution { // DP (TOP-DOWN), TC: O(n * m) where n = length of the array, m = amount
    public int change(int amount, int[] coins) {
        int n = coins.length, dp[][] =  new int[n][amount + 1];
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));
        
        return f(n - 1, coins, amount, dp);
    }
  
    public static int f(int n, int[] coins, int amount, int[][] dp) {
      if(n == 0) return amount % coins[0] == 0 ? 1 : 0;
      
      if(dp[n][amount] != -1) return dp[n][amount];
      
      int notTake = f(n - 1, coins, amount, dp);
      int take = 0;
      
      if(coins[n] <= amount) take = f(n, coins, amount - coins[n], dp);

      return dp[n][amount] = take + notTake;
    }
}