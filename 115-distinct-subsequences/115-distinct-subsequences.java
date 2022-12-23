class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return f(s, t, n-1, m-1, dp);
    }
    
    private int f(String s, String t, int i, int j, int[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s.charAt(i) == t.charAt(j)) return dp[i][j] = f(s, t, i-1, j-1, dp) + f(s, t, i-1, j, dp);
        else return dp[i][j] = f(s, t, i-1, j, dp);
    }
}