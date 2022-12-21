class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        return f(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }
    
    public int f(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s1.charAt(i) == s2.charAt(j)) return 0 + f(s1, s2, i - 1, j - 1, dp);
        
        return dp[i][j] = 1 + Math.min(f(s1, s2, i-1, j-1, dp), 
                            Math.min(f(s1, s2, i-1, j, dp), f(s1, s2, i, j-1, dp)));
    }
}