class Solution { // DP, TOP-DOWN, TC: O(n*m)
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts); /* as it will help us at cutting each positions */
        
        int N = cuts.length;
        int[] arr = new int[N+2];
        arr[0] = 0; // starting point of stick
        arr[arr.length - 1] = n; // ending point of stick
        
        int[][] dp = new int[N+2][N+2]; // 2 indices changing (since we are cutting the stick into 2 halves, to keep track of starting and ending indices) 
        for(int[] vec : dp)
            Arrays.fill(vec, -1);
        
        int count = 1;
        for(int c : cuts) 
            arr[count++] = c;
        
        return solve(0, arr.length-1, arr, dp);
    }
    public int solve(int left, int right, int[] cuts, int[][] dp) {
        if(right - left >= 2) {
            
            if(dp[left][right] != -1)
                return dp[left][right];
            
            int min = Integer.MAX_VALUE;
            
            for(int i = left + 1; i < right; i++) { /* left -> leftmost index of stick, right -> rightmost index of stick */
                int cost = (cuts[right] - cuts[left]) + solve(left, i, cuts, dp) + solve(i, right, cuts, dp);
                
                min = Math.min(cost, min);
            }
            
            return dp[left][right] = min;
        }
        
        return 0;
    }
}