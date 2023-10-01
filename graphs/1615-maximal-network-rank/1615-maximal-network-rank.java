class Solution { // Graph, TC: O(v^2), where v is the number of cities 
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] ranks = new int[n];
        boolean[][] areConnected = new boolean[n][n];
        
        // Calculating the network rank of directly connected cities
        for(int[] road : roads) {
            
            int u = road[0];
            int v = road[1];
            
            ranks[u]++;
            ranks[v]++;
            
            areConnected[u][v] = true;
            areConnected[v][u] = true;
        }
        
        int maxRank = 0;
        for(int i = 0; i < n; i++) {
            
            for(int j = i+1; j < n; j++) {
                
                int rank = ranks[i] + ranks[j];
                
                // Since both the cities are directly connected we will only count the rank once
                if(areConnected[i][j]) 
                    rank--;
                
                maxRank = Math.max(rank, maxRank);
            }
        }
        
        return maxRank;
    }
}