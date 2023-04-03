class Solution {
    int m, n;
    int[][] apples;
    int[][][] dp; // row, col, k is changing
    int MOD = (int)1e9 + 7;
    
    public int ways(String[] pizza, int k) {
        this.m = pizza.length;
        this.n = pizza[0].length();
    
        this.apples = new int[m+1][n+1];
        this.dp = new int[m+1][n+1][11];
        
        for(int[][] arr2D : dp)
            for(int[] arr : arr2D)
                Arrays.fill(arr, -1);
        
        // apples[i][j] = number of apples from [i][j] --> [m-1][n-1] 2d grid
        for(int i = m-1; i >= 0; i--) {
            
            for(int j = n-1; j >= 0; j--) {
                
                apples[i][j] = apples[i][j+1];
                
                for(int row=i; row < m; row++) {
                    
                    if(pizza[row].charAt(j) == 'A')
                        apples[i][j]++;
                    
                }
            }
        }
        return ways(0, 0, k);
    }
    public int ways(int i, int j, int k) {
        if(apples[i][j] < k) // piece doesn't have enough apples as k
            return 0;
        
        if(k == 1) { // for exactly 1 piece left
            if(apples[i][j] >= 1)
                return 1;
            
            return 0;
        }
        
        if(dp[i][j][k] != -1)
            return dp[i][j][k];
        
        int res = 0;
        
        // horizontal cut
        for(int row = i + 1; row < m; row++) {
            int lowerPieceApples = apples[row][j];
            int upperPieceApples = apples[i][j] - lowerPieceApples;
            
            if(upperPieceApples >= 1 && lowerPieceApples >= k-1)
                res = (res%MOD + ways(row, j, k-1)%MOD)%MOD;
        }
        
        // vertical cut
        for(int col = j + 1; col < n; col++) {
            int rightPieceApples = apples[i][col];
            int leftPieceApples = apples[i][j] - rightPieceApples;
            
            if(leftPieceApples >= 1 && rightPieceApples >= k-1)
                res = (res%MOD + ways(i, col, k-1)%MOD)%MOD;
        }
        
        return dp[i][j][k] = res;
    }
}