class Solution {
    private final int MOD = (int)1e9 + 7;
    
    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()+1];
        
        Arrays.fill(dp, -1);
        
        return solve(0, s, k, dp);
    }
    public int solve(int start, String s, int k, int[] dp) {
        if(start >= s.length()) // since we reach till the end of string atleast 1 way is possible
            return 1;
        
        if(s.charAt(start) == '0') // immediately return
            return 0;
        
        if(dp[start] != -1)
            return dp[start];
        
        long ans = 0, num = 0;
        
        for(int end = start; end < s.length(); end++) {
            
            num = (num * 10) + s.charAt(end) - '0'; // consecutively calculate number of possible results instead of looping
            
            if(num > k) // termination case
                break;
            
            ans = (ans%MOD + solve(end+1, s, k, dp)%MOD)%MOD;
            
        }
        
        return dp[start] = (int)ans;
    }
}