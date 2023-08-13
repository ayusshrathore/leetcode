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
<<<<<<< HEAD
<<<<<<< HEAD
=======
            
            if(result)
                return dp[i] = true;
>>>>>>> edca53a (Time: 10 ms (61.17%), Space: 63.1 MB (15.53%) - LeetHub)
=======
>>>>>>> b86bd33 (Time: 13 ms (34.95%), Space: 62.9 MB (18.45%) - LeetHub)
        }
        
        // rule 2
        if(i+2 < n && nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) {
            result |= solve(i+3, n, nums, dp);
<<<<<<< HEAD
<<<<<<< HEAD
=======
            
            if(result)
                return dp[i] = true;
>>>>>>> edca53a (Time: 10 ms (61.17%), Space: 63.1 MB (15.53%) - LeetHub)
=======
>>>>>>> b86bd33 (Time: 13 ms (34.95%), Space: 62.9 MB (18.45%) - LeetHub)
        }
        
        // rule 3
        if(i+2 < n && nums[i+1] - nums[i] == 1 && nums[i+2] - nums[i+1] == 1) {
            result |= solve(i+3, n, nums, dp);
<<<<<<< HEAD
<<<<<<< HEAD
        }
        
        return dp[i] = result;
=======
            
            if(result)
                return dp[i] = true;
        }
        
        return dp[i] = false;
>>>>>>> edca53a (Time: 10 ms (61.17%), Space: 63.1 MB (15.53%) - LeetHub)
=======
        }
        
        return dp[i] = result;
>>>>>>> b86bd33 (Time: 13 ms (34.95%), Space: 62.9 MB (18.45%) - LeetHub)
    }
}