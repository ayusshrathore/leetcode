class Solution { // DFS
    private int n;
    private int count;
    
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
            
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1) { // means connected to each other (undirected)
                    adj.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                } 
            }
        }
        
        for(int i = 0; i < n; i++)
            if(!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        
        return count;
    }
    private void dfs(int u, Map<Integer, List<Integer>> adj, boolean[] visited) {
        visited[u] = true; // mark as visited
        
        if(!adj.containsKey(u))
            return;
        
        for(int v : adj.get(u)) {
            if(!visited[v]) 
                dfs(v, adj, visited);
        }
    }
}