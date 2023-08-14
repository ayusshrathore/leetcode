class Solution { // DP, TOP-DOWN, TC: O(n+m)
    private int m = 0, n = 0;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        
        int[][] dp =  new int[m+1][n+1];
        
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return solve(0, 0, obstacleGrid, dp);
    }
    private int solve(int i, int j, int[][] obstacleGrid, int[][] dp) {
        if(i >= m || j >= n || obstacleGrid[i][j] == 1) // reached out of bounds or encountered an obstacle
            return 0;
       
        if(i == m - 1 && j == n - 1) // it's the bottom-right corner
            return 1;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int result = 0;
        
        // Down move
        result += solve(i+1, j, obstacleGrid, dp);
        
        // Right move
        result += solve(i, j+1, obstacleGrid, dp);
        
        return dp[i][j] = result;
    }
}