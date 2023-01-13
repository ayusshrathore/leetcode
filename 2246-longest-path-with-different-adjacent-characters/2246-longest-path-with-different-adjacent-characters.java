class Solution {
    static int res;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
        res = 0;

        for (int i = 1; i < n; i++) {
            int u = i;
            int v = parent[i];

            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(adj, 0, -1, s);
        return res;
    }

    private static int dfs(List<Integer>[] adj, int curr, int parent, String s) {
        int max = 0;
        int secondMax = 0;

        for (int child : adj[curr]) {
            if (child == parent) continue;

            int childMax = dfs(adj, child, curr, s);

            if (s.charAt(child) == s.charAt(curr)) continue;

            if (childMax > secondMax) secondMax = childMax;
            if (secondMax > max) {
                int temp = max;
                max = secondMax;
                secondMax = temp;
            }
        }

        int anyOnePath = Math.max(max, secondMax) + 1;
        int onlyRoot = 1;
        int anyPathBelowRoot = 1 + max + secondMax;

        res = Math.max(Math.max(res, anyOnePath), Math.max(onlyRoot, anyPathBelowRoot));

        return Math.max(anyOnePath, onlyRoot);
    }
}