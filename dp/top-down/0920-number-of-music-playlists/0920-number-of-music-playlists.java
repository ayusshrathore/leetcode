class Solution { // DP (TOP-DOWN), TC: O(goal * n)
    private final int MOD = (int) 1e9+7;
    
    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal+1][n+1];
        for(long[] arr : dp)
            Arrays.fill(arr, -1);
        
        return (int)solve(n, goal, k, 0, 0, dp);
    }
    private long solve(int n, int goal, int k, int totalSongs, int uniqueSongs, long[][] dp) {
        if(totalSongs == goal) { 
            if(uniqueSongs == n)
                return 1; // if listened to goal number of songs with n unique songs
            
            return 0; // not possible since we didn't listened n unique songs
        }
            
        if(dp[totalSongs][uniqueSongs] != -1)
            return dp[totalSongs][uniqueSongs];
        
        long result = 0;
        /*
            So for every song we have two options
            1. To play a unique song from playlist
            2. To replay a song
            
            also with playing a unique song we have actually (n - currently played unique songs) options to choose from (simple permutation)
            
            and while replaying a song we actually have (currently played unique songs - k) options to choose every time we try to listen to a already listened song
            
        */
        if(uniqueSongs < n) {
            result += (n - uniqueSongs) * solve(n, goal, k, totalSongs+1, uniqueSongs+1, dp); // option1   
        }
        
        if(uniqueSongs > k) {
            result += (uniqueSongs - k) * solve(n, goal, k, totalSongs+1, uniqueSongs, dp); // option 2  
        }
        
        return dp[totalSongs][uniqueSongs] = (result % MOD);
        
    }
}