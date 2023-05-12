class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        
        Arrays.fill(dp, -1);
        
        return solve(0, n, questions, dp);
    }
    public long solve(int i, int n, int[][] questions, long[] dp) {
        if(i >= n)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        long take = questions[i][0] + solve((i+1)+questions[i][1], n, questions, dp); // since there is 1based indexing so (i+1)
        
        long notTake = solve(i+1, n, questions, dp);
        
        return dp[i] = Math.max(take, notTake);
    }
}