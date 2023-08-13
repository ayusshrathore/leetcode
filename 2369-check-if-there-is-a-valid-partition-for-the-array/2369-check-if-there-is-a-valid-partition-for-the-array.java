class Solution { // DP, TOP-DOWN, TC: O(n)
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        
        Boolean[] dp = new Boolean[n+1];
        
        return solve(0, n, nums, dp);
    }
    private boolean solve(int i, int n, int[] nums, Boolean[] dp) {
        if(i >= n)
            return true;
        
        if(dp[i] != null)
            return dp[i];
        
        boolean result = false;
        
        // rule 1
        if(i+1 < n && nums[i] == nums[i+1]) {
            result |= solve(i+2, n, nums, dp);
            
            if(result)
                return dp[i] = true;
        }
        
        // rule 2
        if(i+2 < n && nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) {
            result |= solve(i+3, n, nums, dp);
            
            if(result)
                return dp[i] = true;
        }
        
        // rule 3
        if(i+2 < n && nums[i+1] - nums[i] == 1 && nums[i+2] - nums[i+1] == 1) {
            result |= solve(i+3, n, nums, dp);
            
            if(result)
                return dp[i] = true;
        }
        
        return dp[i] = false;
    }
}