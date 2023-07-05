class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        /* Smallest set of vertices from which all nodes in the graph are reachable will always be equal to no. of nodes with indegree == 0 */
        
        for(List<Integer> vec : edges) { /* those indices with an incoming edge will be marked as visited since they have an indegree > 0 */
            int u = vec.get(0);
            int v = vec.get(1);
            
            visited[v] = true;
        }
        
        for(int i = 0; i < visited.length; i++)
            if(!visited[i]) /* populating indices with indegree == 0 */
                res.add(i);
        
        return res;
    }
}