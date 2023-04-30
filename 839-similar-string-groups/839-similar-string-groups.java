
class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++)  
            for (int j = i; j < n; j++)
                if (isSimilar(strs[i], strs[j])) { // build adj of strings where strings with similarity will be connected together
                    adj.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j); // undirected
                    adj.computeIfAbsent(j, k -> new ArrayList<Integer>()).add(i);
                }
        
        boolean visited[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) 
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        
        return count;
    }
    private void dfs(int u, Map<Integer, List<Integer>> adj, boolean visited[]) { // classic dfs
        visited[u] = true;
        
        if (!adj.containsKey(u))
            return;
        
        for (int v : adj.get(u)) 
            if (!visited[v]) 
                dfs(v, adj, visited);
            
        
    }
    private boolean isSimilar(String s1, String s2) {
        int m = s1.length();
        int diff = 0;
        
        for (int i = 0; i < m; i++) 
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
            
        return diff == 0 || diff == 2;
    }
}
