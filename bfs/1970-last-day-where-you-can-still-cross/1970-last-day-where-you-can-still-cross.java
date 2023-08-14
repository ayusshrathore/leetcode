class Solution { // BFS
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
            
            if(grid[0][j] == 0 && BFS(grid, 0, j)) { // if land start from the first row of that col
                return true;
            }
        }
        
        return false;
    }
    public boolean BFS(int[][] grid, int i, int j) {
        
        Queue<Pair<Integer, Integer>> que = new ArrayDeque<>();
        que.add(new Pair<>(i, j));
        grid[i][j] = 1; // fill water
        
        while(!que.isEmpty()) {
            Pair<Integer, Integer> p = que.poll();
            
            int x = p.getKey();
            int y = p.getValue();
            
            if(x == ROW - 1)
                return true;
            
            for(int[] dir : directions) { // explore all neighbours
                int new_x = x + dir[0];
                int new_y = y + dir[1];
                
                if(new_x >= 0 && new_x < ROW && new_y >= 0 && new_y < COL && grid[new_x][new_y] == 0) {
                    grid[new_x][new_y] = 1; // mark visited
                    que.add(new Pair<>(new_x, new_y));
                }
            }
        }
        
        return false;
    }
}