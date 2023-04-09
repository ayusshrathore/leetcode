class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int N = colors.length();
        
        if(edges.length == 0) return 1;
        
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[N];
        
        for(int i = 0; i <= edges.length; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int[] vec : edges) {
            int u = vec[0];
            int v = vec[1];
            
            adj.get(u).add(v);
            indegree[v]++; // u -> v (edge from u to v)
        }
        
        int[][] dp = new int[N][26]; // dp[node][color] = x (for all paths ending at 'node' with color = {'a', 'b', 'c', ....'z'} with max path value = x)
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < N; i++)
            if(indegree[i] == 0) {
                q.add(i);
                dp[i][colors.charAt(i) - 'a'] = 1;
            }
        
        int result = 0;
        int numberOfNodes = 0;
        
        while(!q.isEmpty()) {
            int u = q.remove();
            numberOfNodes++; // since we have seen the node
            result = Math.max(result, dp[u][colors.charAt(u) - 'a']); // dp[node][color corresponding to that node]
            
            for(int v : adj.get(u)) {
                for(int i = 0; i < 26; i++)
                    dp[v][i] = Math.max(dp[v][i], dp[u][i] + (colors.charAt(v) - 'a' == i ? 1 : 0)); // max value till previous node + 1 (for that specific color)
                
                indegree[v]--;
                if(indegree[v] == 0)
                    q.add(v);
            }
        }
        
        if(numberOfNodes < N)
            return -1; // cycle exists
        
        return result;    
    }
}