class Solution { // Optimal approach (HashTable)
    public int equalPairs(int[][] grid) {
        Map<String, Integer> mp = new HashMap<>();
        
        for(int[] arr : grid) { // row elements frequency
            StringBuilder sb = new StringBuilder();
            
            for(int ele : arr)
                sb.append('-'+ele);
            
            mp.put(sb.toString(), mp.getOrDefault(sb.toString(), 0) + 1);
        }
        
        int res = 0;
        
        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < grid.length; j++)
                sb.append('-'+grid[j][i]);
            
            res += mp.getOrDefault(sb.toString(), 0);
        }
        
        return res;
    }
}