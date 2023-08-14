class Solution {
    int n, m;
    int numberOfEnclaves = 0;
    
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int res = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                numberOfEnclaves = 0;
                if(grid[i][j] == 1 && dfs(i, j ,grid)){// start from the land cell itself
                    res += numberOfEnclaves;
                } 
            }
        
        return res;
    }
    public boolean dfs(int r, int c, int[][] grid) {
        if(r < 0 || r >= m || c < 0 || c >= n) // off the boundary
            return false;
        
        if(grid[r][c] == 0)// water cell
            return true;
        
        grid[r][c] = 0;
        
        boolean left = dfs(r, c-1, grid);
        boolean right = dfs(r, c+1, grid);
        boolean up = dfs(r-1, c, grid);
        boolean bottom = dfs(r+1, c, grid);
        
        if(left && right && up && bottom) // is a enclave
            numberOfEnclaves++;
        
        return left && right && up && bottom;
    }
}