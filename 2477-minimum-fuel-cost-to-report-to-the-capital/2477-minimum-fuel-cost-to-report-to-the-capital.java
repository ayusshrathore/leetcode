class Solution {
    long res = 0; int s;

    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList(); s = seats;
        for (int i = 0; i < roads.length + 1; i++) graph.add(new ArrayList());
        for (int[] r: roads) {
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        dfs(0, 0, graph);
        return res;
    }
    private int dfs(int node, int parent, List<List<Integer>> graph) {
        int people = 1;
        for (int curr : graph.get(node)) {
            if (curr == parent) continue;
            people += dfs(curr, node, graph);
        }
        int cost = people / s;
        if (people % s != 0) cost++;
        if (node != 0) res += cost;
        return people;
    }
}