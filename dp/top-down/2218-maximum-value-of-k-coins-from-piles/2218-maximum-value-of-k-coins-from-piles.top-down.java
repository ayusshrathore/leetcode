class Solution { // top-down
    private int n;
    
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.n = piles.size();
        
        int[][] dp = new int[n+1][k+1];
        
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        
        return solve(0, k, piles, dp);
    }
    public int solve(int i, int k, List<List<Integer>> piles, int[][] dp) {
        if(i >= n)
            return 0;
        
        if(dp[i][k] != -1)
            return dp[i][k];
        
        int notTaken = solve(i+1, k, piles, dp); // idx goes on, but k remains the same
        
        int taken = Integer.MIN_VALUE, sum = 0;
        
            for(int j = 0; j < Math.min(k, piles.get(i).size()); j++) { // min(number of coins left to be collected, size of pile)
                sum += piles.get(i).get(j);
                
                if(k-(j+1) >= 0)
                    taken = Math.max(taken, sum + solve(i+1, k-(j+1), piles, dp)); // calculate the the sum of coins for the next pile
                
            }
        
        return dp[i][k] = Math.max(taken, notTaken);
    }
}
