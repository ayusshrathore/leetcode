class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;
    
        int n = nums.length, target = total/2;
        
        int[][] dp = new int[n][target+1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        
        return f(n - 1, total/2, nums, dp);
    }
    
    private boolean f(int idx, int target, int[] nums, int[][] dp) {
        if (target == 0) return true;
        if (idx == 0) return nums[idx] == target;
        
        if (dp[idx][target] != -1) return dp[idx][target] == 0 ? false : true;
        
        boolean notTake = f(idx - 1, target, nums, dp);
        
        boolean take = false;
        if (target >= nums[idx]) {
            take = f(idx - 1, target - nums[idx], nums, dp);
            dp[idx][target] = take || notTake ? 1 : 0;
        }
        
        return take || notTake;
    }
}