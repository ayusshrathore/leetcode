class Solution {
    private int n, m;
    
    public int minimumDeleteSum(String s1, String s2) {
        n = s1.length();
        m = s2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return f(0, 0, s1, s2, dp);
    }
    
    private int f(int i, int j, String s1, String s2, int[][] dp) {
        if (i >= n && j >= m) {
            return 0;
        }
        
        if (i >= n) {
            return (int)s2.charAt(j) + f(i, j + 1, s1, s2, dp);
        }
        
        if (j >= m) {
            return (int)s1.charAt(i) + f(i + 1, j, s1, s2, dp);
        }
        
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s1.charAt(i) == s2.charAt(j)) {
            return f(i + 1, j + 1, s1, s2, dp);
        }
        
        int delete_s1 = (int)s1.charAt(i) + f(i + 1, j, s1, s2, dp);
        
        int delete_s2 = (int)s2.charAt(j) + f(i, j + 1, s1, s2, dp);
        
        return dp[i][j] = Math.min(delete_s1, delete_s2);
        
    }
}