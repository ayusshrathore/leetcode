class Solution {
    private final int MOD = (int)1e9+7;
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[n+1][minProfit+1][profit.length+1]; // 3 states are changing -> currPeople involved, currProfit, index
        for(int[][] mat : dp)
            for(int[] arr : mat)
                Arrays.fill(arr, -1);
        
        return solve(n, minProfit, 0, 0, group, profit, 0, dp);
    }
    public int solve(int n, int minProfit, int currProfit, int currPeople, int[] group, int[] profit, int idx, int[][][] dp) {
        if(currPeople > n)
            return 0;
        
        if(idx >= profit.length) {
            if(currProfit >= minProfit) // we found 1 way if and only if currProfit is greater than minProfit and currPeople involved in crime are less than n
                return 1;
            
            return 0;
        }

        if(dp[currPeople][currProfit][idx] != -1)
            return dp[currPeople][currProfit][idx];
        
        long notPick = solve(n, minProfit, currProfit, currPeople, group, profit, idx+1, dp) % MOD;
        
        // since profit will only gonna increase as soon as it increases upto minProfit we can make a hold there for drastically reducing the size of our dp table
        long pick = solve(n, minProfit, Math.min(minProfit, currProfit+profit[idx]), currPeople+group[idx], group, profit, idx+1, dp) % MOD;
        
        return dp[currPeople][currProfit][idx] = (int)(notPick%MOD + pick%MOD)%MOD;
    }
}