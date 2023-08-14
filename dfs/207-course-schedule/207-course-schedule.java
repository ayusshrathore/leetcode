class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        
        for(int[] vec : prerequisites) {
            int a = vec[0];
            int b = vec[1];

            adj[b].add(a);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i] && isCycleDFS(adj, i, visited, inRecursion))
                return false;
        }
        
        return true;
    }

    private boolean isCycleDFS(List<Integer>[] adj, int u, boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adj[u]) {
            if (!visited[v] && isCycleDFS(adj, v, visited, inRecursion)) {
                return true;
            }
            else if (inRecursion[v]) {
                return true;
            }
        }

        inRecursion[u] = false;
        return false;
    }
}