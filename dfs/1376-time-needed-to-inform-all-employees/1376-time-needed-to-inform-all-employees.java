class Solution { // DFS
    
    private int maxTime = 0;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i = 0; i < manager.length; i++) { // Fill the adj list  {Manager -> employees}
            int v = i; // employee
            int u = manager[i]; // manager
            
            if(manager[i] != -1) // if employee is not the manager himself
                adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v); // directed
        }
        
        dfs(adj, headID, manager, informTime, 0);
        
        return maxTime;
    }
    public void dfs(Map<Integer, List<Integer>> adj, int currEmployee, int[] manager, int[] informTime, int currTime) {
        
        maxTime = Math.max(maxTime, currTime);
        
        for(int employee : adj.getOrDefault(currEmployee, new ArrayList<>()))  { // currEmployee -> subordinates
            
            dfs(adj, employee, manager, informTime, currTime+informTime[currEmployee]);
        }
        
    }
}