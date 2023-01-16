class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        Arrays.fill(rank, 1); // initially rank is 1 for each nodes

        for(int i = 0; i < n; i++)
            parent[i] = i; // initially for every node they are the parent for them

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < n; i++)
            adj.put(i, new ArrayList<>());

        for(int[] edge : edges){ // populate adj list
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v); // given undirected graph
            adj.get(v).add(u);
        }

        Map<Integer, List<Integer>> valToNodes = new HashMap<>(); // val -> {nodes}
        int m = Arrays.stream(vals).max().getAsInt(); // get the max of vals to init valToNodes ArrayList<>
        
        for(int i = 0; i <= m; i++)
            valToNodes.put(i, new ArrayList<>());
        
        for(int i = 0; i < n; i++){ // populate map with val -> nodes
            int value = vals[i];
            valToNodes.get(value).add(i);
        }

        int result = n; // every node given is good for themselves

        boolean[] isActive = new boolean[n];
        Arrays.fill(isActive, false); // starting every node is inactive

        for(List<Integer> val : valToNodes.values()){
            List<Integer> nodes = new ArrayList<>(val);
            for(int u : nodes){
                for(int v : adj.get(u)) // trying to check which nodes were adjacent to each other using adj
                    if(isActive[v]) union(u, v, parent, rank);

                isActive[u] = true; // u is visited
            }
            List<Integer> theirParents = new ArrayList<>();
            for(int u : nodes){
                int whoIsParent = find(u, parent); // getting the parent for each node to have a count of which 2 
                theirParents.add(whoIsParent); // nodes belong to same group or component
            }

            Collections.sort(theirParents); // sort thierParents array to have a easy total counts
            int sz = theirParents.size();

            for(int j = 0; j < sz; j++){
                int count = 0; // initially count is zero for parent

                int currParent = theirParents.get(j);

                while(j < sz && theirParents.get(j) == currParent){
                    count++;  // count how may nodes have same parent
                    j++;
                }
                j--; // because j moved 1 step forward

                int formula = count * (count - 1) / 2; // ncr
                result += formula;
            }
        }
        return result;
    }

    // DSU Part
    public int find(int x, int[] parent){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }
    public void union(int x, int y, int[] parent, int[] rank){
        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if(xParent == yParent) return; // if same set then no need to converge

        if(rank[xParent] > rank[yParent]) // whose rank is bigger will be the parent
            parent[yParent] = xParent; // parent of yParent is now xParent

        else if(rank[xParent] < rank[yParent])
            parent[xParent] = yParent; // parent of xParent is now yParent

        else{
            parent[xParent] = yParent; // if rank is same for both make anyone parent
            rank[yParent] += 1; // increment the rank by 1
        }
    }
}