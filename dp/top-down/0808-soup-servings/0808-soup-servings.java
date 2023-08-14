class Solution { // DP top-down, TC: O(n^2)
    private int[][] quantities = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};
    
    public double soupServings(int n) {
        if(n >= 5000)
            return 1;
        
        double[][] dp = new double[n+1][n+1];
        
        for(double[] arr : dp) {
            Arrays.fill(arr, -1.0);
        }
        
        return solve(n, n, dp);
    }
    private double solve(int A, int B, double[][] dp) { // calc prob of A getting emptied
        if(A <= 0 && B <= 0) return 0.5; // prob of both soups getting emptied (given)
        
        if(A <= 0) return 1.0; // since quantity of A = 0 (then prob of it being emptied is 1)
        
        if(B <= 0) return 0.0; // since we don't require prob of B getting emptied

        if(dp[A][B] != -1.0)
            return dp[A][B];
        
        double prob = 0.0;
        for(int[] serve : quantities) { // for each 4 operations 
            int A_taken = serve[0];
            int B_taken = serve[1];
            
            prob += solve(A-A_taken, B-B_taken, dp);
        }
        
        return dp[A][B] = 0.25 * prob;
    }
}