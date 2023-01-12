class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
            
        for (int[] arr : edges) {
            int u = arr[0]; int v = arr[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] res = new int[n];
        dfs(adj, 0, -1, res, labels);
        return res;
    }

    private static int[] dfs(List<Integer>[] adj, int curr, int parent, int[] res, String labels) {
        int[] myCount = new int[26];
        char myLabel = labels.charAt(curr);

        myCount[myLabel - 'a'] = 1;
        for (int child : adj[curr]) {
            if (child == parent) continue;

            int[] childCount = new int[26];
            childCount = dfs(adj, child, curr, res, labels);
            for (int i = 0; i < 26; i++) 
                myCount[i] += childCount[i];
        }

        res[curr] = myCount[myLabel - 'a'];
        return myCount;
    }
}