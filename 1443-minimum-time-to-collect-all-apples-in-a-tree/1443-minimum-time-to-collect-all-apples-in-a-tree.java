class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
    
        for(int[] arr : edges){
            int u = arr[0]; int v = arr[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        return dfs(adj, 0, -1, hasApple);
    }

    private static int dfs(List<Integer>[] adj, int curr, int parent, List<Boolean> hasApple) {
        int time = 0;

        for (int child : adj[curr]) {
            if (child == parent) continue;

            int timeFromChild = dfs(adj, child, curr, hasApple);

            if (timeFromChild > 0 || hasApple.get(child))
                time += timeFromChild + 2;
        }
        return time;
    }
}