class Solution { // DFS
    private int ROW;
    private int COL;
    
    private int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int latestDayToCross(int row, int col, int[][] cells) {
        ROW = row;
        COL = col;
        
        int l = 0;
        int r = cells.length - 1;
        
        int lastDay = 0;
        
        while(l <= r) {
            int mid = (l + r) >>> 1;
            
            if(canCross(cells, mid)) {
                lastDay = mid + 1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return lastDay;
    }
    
    public boolean canCross(int[][] cells, int mid) {
        int[][] grid = new int[ROW][COL];
        
        for(int i = 0; i <= mid; i++) {
            
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            
            grid[x][y] = 1; // filling water
        }
        
        for(int j = 0; j < COL; j++) {
            
            if(grid[0][j] == 0 && DFS(grid, 0, j)) { // if land start from the first row of that col
                return true;
            }
        }
        
        return false;
    }
    public boolean DFS(int[][] grid, int i, int j) {
        
        if(i < 0 || i >= ROW || j < 0 || j >= COL || grid[i][j] == 1) // out of bounds or visited
            return false;
        
        
        if(i == ROW - 1)
            return true;
        
        grid[i][j] = 1; // mark visited;
        
        for(int[] dir : directions) {
            
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            
            if(DFS(grid, new_i, new_j)) {
                return true;
            }
        }
        
        return false;
    }
}