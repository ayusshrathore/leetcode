class Solution { // top-down approach
    public int maxScore(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Map<String, Integer> dp = new HashMap<>();
        
        return topDown(nums, visited, 1, n, dp);
    }
    public int topDown(int[] nums, boolean[] visited, int operation, int n, Map<String, Integer> dp) {
        int maxScore = 0;
        
        String str = Arrays.toString(visited);
        
        if(dp.containsKey(str))
            return dp.get(str);
        
        for(int i = 0; i <= n-2; i++) {
            if(visited[i]) // skip already taken indices
                continue;
            
            for(int j = i+1; j < n; j++) {
                if(visited[j])
                    continue;
                
                visited[i] = true;
                visited[j] = true;
                
                int score = operation * gcd(nums[i], nums[j]);
                int remaningScore = topDown(nums, visited, operation+1, n, dp);
                
                visited[i] = false; // since for next number to be fixed mark visited cells unvisited again
                visited[j] = false;
                
                maxScore = Math.max(maxScore, score+remaningScore);
            }
        }
        
        dp.put(Arrays.toString(visited), maxScore);
        
        return maxScore;
    }
    private int gcd(int a, int b){
        return a == 0 ? b : gcd(b % a, a);
    }
}