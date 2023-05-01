
class Solution { //dsu
    private int[] parent;
    private int[] rank;
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0; i < n; i++) // at starting everyone is parent of itself
            parent[i] = i;
        
        int groupCount = n; // initially every string forms individual groups
        
        for(int i = 0; i < n; i++)
            for(int j = i+1; j < n; j++) {
                if(isSimilar(strs[i], strs[j]) && find(i) != find(j)) { // 2 strings are similar, but they have different parents then merge them together to form a group
                    union(i, j);
                    groupCount--;
                }
            }
        
        return groupCount;
    }
    private int find(int x) {
        if(parent[x] == x)
            return x;
        
        return parent[x] = find(parent[x]);
    }
    private void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        
        if(rank[xParent] > rank[yParent])
            parent[yParent] = xParent;
        else if(rank[yParent] > rank[xParent])
            parent[xParent] = yParent;
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
    private boolean isSimilar(String s1, String s2) {
        int m = s1.length();
        int diff = 0;
        
        for (int i = 0; i < m; i++) 
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
            
        return diff == 0 || diff == 2;
    }
}
