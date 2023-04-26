class Solution { // bottom up
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        
        int[][] dp = new int[n+1][k+1]; // dp[n][coins] states that upto pile n we can take max 'coins' coins
        
        for(int i = 1; i <= n; i++) // starting from 1st pile filling the rows
            
            for(int coins = 1; coins <= k; coins++) { // going from zero upto k coins in each pile (filling the cols)
                
                int sum = 0;
                
                for(int currCoins = 0; currCoins <= Math.min(piles.get(i-1).size(), coins); currCoins++) { // currCoins -> no. of coins taken so far
                    
                    if(currCoins > 0)
                        sum += piles.get(i-1).get(currCoins-1);
                    
                    dp[i][coins] = Math.max(dp[i][coins], sum + dp[i-1][coins-currCoins]); 
                }
            }   
                
        return dp[n][k];
    }
}