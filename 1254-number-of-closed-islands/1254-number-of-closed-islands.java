class Solution {
    int n, m;
    
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int numberOfClosedIslands = 0;
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 0) // starting point should be land
                    if(dfs(i, j, grid))
                        numberOfClosedIslands++;
        
        return numberOfClosedIslands;
    }
    public boolean dfs(int r, int c, int[][] grid) {
        if(r < 0 || r >= m || c < 0 || c >= n) // (out of bounds) not closed
            return false;
        
        if(grid[r][c] == 1) // (water) closed 
            return true;
        
        grid[r][c] = 1; // mark visited
        
        boolean left = dfs(r, c-1, grid);
        boolean right = dfs(r, c+1, grid);
        boolean up = dfs(r-1, c, grid);
        boolean down = dfs(r+1, c, grid);
        
        return left && right && up && down;
    }
}