class Solution { // DFS
    public boolean isBipartite(int[][] graph) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        /* colors[i] == 1 [red], colors[i] == 2 [green], colors[i] == 0 [no color] */
        int[] colors = new int[graph.length];
        
        for(int i = 0; i < graph.length; i++) {
            if(colors[i] == 0) { /* isn't visited till yet */
                if(!dfs(graph, i, 1, colors))
                    return false;
            }
        }
        
        return true;
    }
    public boolean dfs(int[][] adj, int currNode, int currColor, int[] colors) {
        /* color the visiting node */
        colors[currNode] = currColor;
        
        /* move to other connected nodes */
        for(int v : adj[currNode]) {
            /* current node have the same color to that of node we are coming from */
            if(colors[v] == colors[currNode])
                return false;
            
            if(colors[v] == 0) { /* if the node isn't visited yet then visit it */
                int nextColor = currColor == 1 ? 2 : 1;
            
                if(!dfs(adj, v, nextColor, colors))
                    return false;
            }
        }
        
        return true;
    }
}