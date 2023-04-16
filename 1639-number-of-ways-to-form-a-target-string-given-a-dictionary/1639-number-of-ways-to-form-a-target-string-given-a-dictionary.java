class Solution {
    private int n, m;
    long mod = (long)1e9+7;
    
    public int numWays(String[] words, String target) {
        this.n = words[0].length();
        this.m = target.length();
        
        int[][] frq = new int[26][n];
        int[][] dp = new int[m+1][n+1];
        
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        
        for(int col = 0; col < n; col++)
            for(String word : words) {
                char ch = word.charAt(col);
                frq[ch-'a'][col]++;                
            }
        
        return solve(0, 0, words, target, frq, dp);
    }
    public int solve(int i, int j, String[] words, String target, int[][] frq, int[][] dp) {
        if(i >= m)
            return 1; // there would be atleast 1 way, since we can only reach the end of the target
        
        if(j >= n)
            return 0; // index goes out of bound of words
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        long notTaken = solve(i, j+1, words, target, frq, dp) % mod;
         
        long taken = (frq[target.charAt(i) - 'a'][j] % mod * solve(i+1, j+1, words, target, frq, dp) % mod) % mod; // utilize current col(since only 1 char per col) & move to next
        
        return dp[i][j] = (int)((taken + notTaken) % mod);
    }
}