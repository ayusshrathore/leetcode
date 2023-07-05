class Solution { // DFS
    
    private double ans = -1.0;
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        
        Map<String, List<Pair<String, Double>>> adj = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            String u = equations.get(i).get(0); // 'a'
            String v = equations.get(i).get(1); // 'b'
            double val = values[i]; // a / b
            
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, val)); // a -> (b, a/b)
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, 1.0/val)); // b -> (a, b/a)
        }
        
        double[] res = new double[queries.size()];
        int i = 0;
        
        for(List<String> query : queries) {
            
            /* [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
                  ^   ^
                 src dest
            */
            String src = query.get(0); 
            String dest = query.get(1);
            
            if(!adj.containsKey(src)) {
                res[i++] = ans;
                continue;
            }
            
            double product = 1.0;
            Set<String> visited = new HashSet<>(); // would be different for each query, since it needs to be refreshed for each set of queries
            
            dfs(adj, src, dest, visited, product);
            
            res[i++] = ans;
            
            ans = -1.0;
        }
        
        return res;
    }
    public void dfs(Map<String, List<Pair<String, Double>>> adj, String src, String dest, Set<String> visited, double product) {
        if(visited.contains(src)) // already visited node [src]
            return;
        
        visited.add(src); // mark this node visited
        
        if(src.equals(dest)) { // we have reached the dest node
            ans = product;
            return;
        }
            
        for(Pair<String, Double> p : adj.get(src)) {
            String v = p.getKey();
            double val = p.getValue();
            
            if(!adj.containsKey(v))
                continue;
            
            dfs(adj, v, dest, visited, product*val);
        }
    }
}