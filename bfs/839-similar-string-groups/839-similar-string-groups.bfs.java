
class Solution { //bfs
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
                bfs(i, adj, visited);
                count++;
            }
        
        return count;
    }
    private void bfs(int u, Map<Integer, List<Integer>> adj, boolean visited[]) { // classic bfs
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(u);
        visited[u] = true;
        
        while(!q.isEmpty()) {
            int ele = q.remove();
                
            if(!adj.containsKey(ele))
                return;
            
            for(int v : adj.get(ele))
                if(!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
        }
            
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
