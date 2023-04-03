class Solution {
    int n;
    
    public int maxSatisfaction(int[] satisfaction) {
        n = satisfaction.length;
        
        int[][] dp = new int[n+1][n+1]; // since 2 quantity varying
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        
        Arrays.sort(satisfaction); // to get -> max time * largest value
        
        return maxSatisfaction(0, 1, satisfaction, dp);
    }
    public int maxSatisfaction(int i, int t, int[] satisfaction, int[][] dp) {
        if(i >= n) return 0;
        
        if(dp[i][t] != -1) return dp[i][t];
        
        int notPick = 0 + maxSatisfaction(i+1, t, satisfaction, dp);
        
        int pick = t * satisfaction[i] + maxSatisfaction(i+1, t+1, satisfaction, dp);
        
        return dp[i][t] = Math.max(pick, notPick);
    }
}