class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        
        for(int[] arr : dp) // 2 indices are changing i, j
            Arrays.fill(arr, -1);
        
        return solve(0, 0, n, m, nums1, nums2, dp);
    }
    public int solve(int i, int j, int n, int m, int[] nums1, int[] nums2, int[][] dp) {
        if(i >= n || j >= m) // as soon as one of the index goes out of bounds
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        /*
         i  
        [1, 4, 2] // case if both the elements at each indices are same
         |    /
        [1, 2, 4]
         j  
        */
        
        /*
               i  
        [1, 4, 2] // when nums1[i] != nums2[j], then - (i+1, j) or (i, j+1)
         |    /
        [1, 2, 4]
            j  
        */
        if(nums1[i] == nums2[j])
            return dp[i][j] = 1 + solve(i+1, j+1, n, m, nums1, nums2, dp);
        
        return dp[i][j] = Math.max(solve(i, j+1, n, m, nums1, nums2, dp), solve(i+1, j, n, m, nums1, nums2, dp)); // otherwise max of both (either i+1, j+1) the possibilities
    }
}