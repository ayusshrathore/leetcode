class Solution { // DP, TOP-DOWN, TC: O(n+m)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return solve(0, 0, m, n, dp);
    }
    private int solve(int i, int j, int m, int n, int[][] dp) {
        if(i == m-1 && j == n-1)
            return 1;
        
        if(i >= m || j >= n)
            return 0;
            
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int result = 0;
        
        // Down move
        result += solve(i+1, j, m, n, dp);
        
        // Right move
        result += solve(i, j+1, m, n, dp);
        
        return dp[i][j] = result;
    }
}