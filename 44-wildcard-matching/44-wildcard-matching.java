class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);
        return f(n - 1, m - 1, s, p, dp);
    }
    
    public boolean f(int n, int m, String s, String p, int[][] dp){
      if(n < 0 && m < 0) return true;
      if(n >= 0 && m < 0) return false;
      
      if(n < 0 && m >= 0){
        for(int i = 0; i <= m; i++)
          if(p.charAt(i) != '*') return false;
        return true;
      }
      
      if(dp[n][m] != -1) return dp[n][m] == 1 ? true : false;

      if(s.charAt(n) == p.charAt(m) || p.charAt(m) == '?'){
        boolean res = f(n - 1, m - 1, s, p, dp);
        dp[n][m] = res == false ? 0 : 1;
        return res;
      } 
        
      else if(p.charAt(m) == '*'){
        boolean res = (f(n - 1, m, s, p, dp) || f(n, m - 1, s, p, dp));
        dp[n][m] = res == false ? 0 : 1;
        return res;
      }
      
      dp[n][m] = 0;
      return false;
    }
}