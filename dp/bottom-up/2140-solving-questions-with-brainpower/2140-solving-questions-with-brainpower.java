class Solution { // bottom-up approach
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[200001]; // dp[i] states that -> max points gained from [i to n-1]
        
        for(int i = n-1; i >= 0; i--) {
            long take = questions[i][0] + dp[i+1+questions[i][1]];
            
            long notTake = dp[i+1];
            
            dp[i] = Math.max(take, notTake);
        }
        
        return dp[0]; // moving from right to left since we can't acutally keep a track of which Ques to skip if we are moving from left -> rigth
    }
}