class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                isCycleDFS(graph, i, visited, inRecursion);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!inRecursion[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean isCycleDFS(int[][] graph, int u, boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;

        for (int v : graph[u]) {
            if (!visited[v] && isCycleDFS(graph, v, visited, inRecursion)) {
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