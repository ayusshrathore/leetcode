class Solution { // DFS
    private int n;
    private int count;
    
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
            
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++)
            if(!visited[i]) {
                dfs(i, visited, isConnected);
                count++;
            }
        
        return count;
    }
    private void dfs(int u, boolean[] visited, int[][] isConnected) {
        visited[u] = true;
        
        for(int v = 0; v < n; v++)
            if(!visited[v] && isConnected[u][v] == 1) {
                dfs(v, visited, isConnected);
            }
    }
}