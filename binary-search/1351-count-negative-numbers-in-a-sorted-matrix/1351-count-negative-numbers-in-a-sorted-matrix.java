class Solution { // Binary Search
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        /*
        [
            [4,3,2,-1],
            [3,2,1,-1],
            [1,1,-1,-2],
            [-1,-1,-2,-3]
        ]
        
        */
        int res = 0;
        for(int i = 0; i < n; i++) {
            int high = m;
            int j = 0;
            int cnt = 0;
            
            while(j < high) {
                int mid = (j + high) >> 1;
                
                if(grid[i][mid] < 0) {
                    high = mid;
                    cnt = m - high;
                }
                else {
                    j = mid + 1;
                }
            }
            res += cnt;
        }
        
        return res;
        
    }
}