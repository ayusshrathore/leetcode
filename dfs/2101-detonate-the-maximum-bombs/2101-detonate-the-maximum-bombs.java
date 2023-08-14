class Solution { // DFS
    
    private double findDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
    }
    
    private int dfs( Map<Integer, List<Integer>> adj, boolean[] visited, int u) {
        visited[u] = true;
        int count = 1;
        if(!adj.containsKey(u)) return count;
        for(int v : adj.get(u)) {
            if(!visited[v]) {
                count += dfs(adj,visited,v);
            }
        }
        return count;
    }
    
    public int maximumDetonation(int[][] bombs) { 
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited;
        int n = bombs.length;
        
        //build the graph
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                double distance = findDistance(bombs[i][0],bombs[i][1], bombs[j][0], bombs[j][1]);
                if((bombs[i][2] * 1.0) >= distance) {
                    //edge i->j
                    adj.computeIfAbsent(i,k->new ArrayList<>()).add(j);
                }
            }
        }
        
        int answer = 0;
        //from each node find the maximum nodes that can be visited
        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            int count = dfs(adj,visited,i);
            answer = Math.max(answer,count);
        }
        return answer;
    }
}