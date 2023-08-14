class Solution { // DFS (marking 1st group of islands visited) + BFS(starting from visited cells to destination to find shortest path)
    private int n, m;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public int shortestBridge(int[][] grid) {
        n = grid.length; m = grid[0].length;
        
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) 
                if(grid[i][j] == 1) { // found 1st land
                    dfs(i, j, visited, grid);
                    return bfs(visited, grid);
                }
        
        return -1; 
    }
    private int bfs(Set<Pair<Integer, Integer>> visited, int[][] grid) {
        Queue<Pair<Integer, Integer>> que = new ArrayDeque<>();
        
        for(Pair<Integer, Integer> p : visited) 
            que.add(p);
        
        int levels = 0;
        
        while(!que.isEmpty()) {
            
            int len = que.size();
            
            while(len-- > 0) {
                Pair<Integer, Integer> p = que.remove();
                
                int i = p.getKey();
                int j = p.getValue();
                
                for(int[] dir : directions) { // visit neighbours
                    int i_ = i + dir[0];
                    int j_ = j + dir[1];
                    
                    if(isSafe(i_, j_) && !visited.contains(new Pair<>(i_, j_))) {
                        if(grid[i_][j_] == 1) { // second land found
                             return levels;
                        }
                        
                        visited.add(new Pair<>(i_, j_));
                        que.add(new Pair<>(i_, j_));
                    }
                }
            }
            
            levels++; // one level is complete
        }
        
        return levels;
        
    }
    private void dfs(int i, int j, Set<Pair<Integer, Integer>> visited, int[][] grid) {
        if(!isSafe(i, j) || visited.contains(new Pair<>(i, j)) || grid[i][j] == 0) /* if cell is already visited or it isn't land */
            return;
        
        visited.add(new Pair<>(i, j));
        
        // visit neighbours of this cell
        for(int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            
            dfs(i_, j_, visited, grid);
        }
    }
    private boolean isSafe(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}