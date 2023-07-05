class Solution { // top-down approach
    private final int MOD = (int) 1e9+7;
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[100001];
        
        Arrays.fill(dp, -1);
        
        return topDown(0, low, high, zero, one, dp);
    }
    public int topDown(int l, int low, int high, int zero, int one, int[] dp) {
        if(l > high) // if length goes out of bounds
            return 0;
        
        if(dp[l] != -1)
            return dp[l];
        
        byte ans = 0;
        if(l >= low && l <= high) // check whether current string is valid
            ans += 1;
        
        int appendOne = topDown(l + one, low, high, zero, one, dp);
        
        int appendZero = topDown(l + zero, low, high, zero, one, dp);
                
        return dp[l] = (ans + appendOne + appendZero) % MOD;
    }
}