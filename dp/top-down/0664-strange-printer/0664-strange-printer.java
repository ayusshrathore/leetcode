class Solution { // DP (top-down), TC: O(n^2 * n), n^2 max-states * O(n) for increasing j greedily (to print similiar chars)
    private int n;
    public int strangePrinter(String s) {
        this.n = s.length();
            
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return solve(0, n-1, s, dp);
    }
    private int solve(int l, int r, String s, int[][] dp) {
        if(l == r)
            return 1;
        
        if(l > r)
            return 0;
            
        int i = l+1;
        while(i <= r && s.charAt(i) == s.charAt(l))  // finding all similiar chars
            i++;
        
        if(i > r) // if goes out of bounds
            return 1;
            
        if(dp[l][r] != -1)
            return dp[l][r];
        
        int basicApproach = 1 + solve(i, r, s, dp); // print all similiar chars
            
        int greedyApproach = Integer.MAX_VALUE;
        for(int j = i; j <= r; j++) {
            if(s.charAt(j) == s.charAt(l)) {
                int ans = solve(i, j-1, s, dp) + solve(j, r, s, dp);
                greedyApproach = Math.min(greedyApproach, ans); 
            }
        }
        
        return dp[l][r] = Math.min(greedyApproach, basicApproach);
    }
}