class Solution { // Brute Force approach
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                int isEqual = 1;
                
                for(int i = 0; i < n; i++) {
                    if(grid[row][i] != grid[i][col]) { // compare row with col
                        isEqual = 0;
                        break;
                    }
                }
                count += isEqual;
            }
        }
        
        return count;
    }
}