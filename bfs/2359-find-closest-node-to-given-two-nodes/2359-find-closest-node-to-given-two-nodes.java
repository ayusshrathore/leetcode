class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
        Arrays.fill(visited1, false);
        Arrays.fill(visited2, false);

        dist1[node1] = 0;
        dist2[node2] = 0;

        // dfs(edges, node1, dist1, visited1);
        // dfs(edges, node2, dist2, visited2);

        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);

        int minDistNode = -1;
        int minDistTillNow = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int max = Math.max(dist1[i], dist2[i]);

            if (minDistTillNow > max) {
                minDistTillNow = max;
                minDistNode = i;
            }
        }

        return minDistNode;
    }

    private static void dfs(int[] edges, int node, int[] dist, boolean[] visited) {
        visited[node] = true;
        int v = edges[node];
        if (v != -1 && !visited[v]) {
            visited[v] = true;
            dist[v] = 1 + dist[node];
            dfs(edges, v, dist, visited);
        }
    }

    private static void bfs(int[] edges, int node, int[] dist) {
        Queue<Integer> que = new LinkedList<>();
        dist[node] = 0;
        boolean[] visited = new boolean[edges.length];
        Arrays.fill(visited, false);
        que.add(node);
        visited[node] = true;

        while(!que.isEmpty()) {
            int u = que.poll();
            int v = edges[u];
            if (v != -1 && !visited[v]) {
                visited[v] = true;
                dist[v] = 1 + dist[u];
                que.add(v);
            }
        }
    }
}