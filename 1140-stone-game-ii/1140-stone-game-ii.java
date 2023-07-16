class Solution { // DP states dp[2][n+1][n+1] -> O(2 * n * n) * n (for loop for stones) -> O(n^2*n) -> O(n^3)
    
    /* GAME STRATEGY
        when it's your turn, do the best
        when it's your opponent's turn, expect the worst
    */
    
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][piles.length+1][piles.length+1];
        
        for(int[][] arrays : dp) {
            for(int[] arr : arrays) {
                Arrays.fill(arr, -1);
            }
        }
        
        return solveForAlice(1, piles, 0, 1, dp);
    }
    public int solveForAlice(int person, int[] piles, int idx, int M, int[][][] dp) {
        if(idx >= piles.length) { 
            return 0;
        }
        
        if(dp[person][idx][M] != -1)
            return dp[person][idx][M];
        
        int stones = 0; // stones Alice will pick
        int result = Integer.MIN_VALUE;
        
        if(person == 0)
            result = Integer.MAX_VALUE;
        
        for(int x = 1; x <= Math.min(2*M, piles.length-idx); x++) { // stones range -> 1 <= x <= min(2*M, piles.length-currIdx) ... since 2*M can go out of bounds
            stones += piles[idx+x-1]; // adding the curr sum into prev (prefix sum), -1 for zero based indexing
            
            if(person == 1) { // when Alice's turn
                result = Math.max(result, stones + solveForAlice(0, piles, idx+x, Math.max(M, x), dp)); // since it's Alice's turn took max
            } else {
                result = Math.min(result, solveForAlice(1, piles, idx+x, Math.max(M, x), dp)); // Bob's turn so the result gonna be min for Alice, acc to game playing strategy
            }
        }
        
        return dp[person][idx][M] = result;
    }
}