class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();
        int m = t.length();
        
        int[][] dp = new int[n+1][m+1]; // 2 indices changing
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        
        // min Insertions would be the length 0f original string - the longest palindromic subsequence
        return n - solve(n-1, m-1, s, t, dp);
    }
    public int solve(int n, int m, String s, String t, int[][] dp) {
        if(n < 0 || m < 0)
            return 0;
        
        if(dp[n][m] != -1)
            return dp[n][m];
        
        if(s.charAt(n) == t.charAt(m)) // since both the characters are equal add 1 to length of the res
            return dp[n][m] = 1 + solve(n-1, m-1, s, t, dp);
        
        return dp[n][m] = Math.max(solve(n, m-1, s, t, dp), solve(n-1, m, s, t, dp));
    }
}