class Solution { // O(N ^ 2 * K)
    int r = 0, c = 0;

    // all possible moves for the knight
    int[][] directions = {{r - 1, c + 2}, {r + 1, c + 2}, {r - 1, c - 2}, {r + 1, c - 2}, {r + 2, c - 1}, {r + 2, c + 1}, {r - 2, c - 1}, {r - 2, c + 1}};

    public double knightProbability(int n, int k, int row, int column) {
        this.r = row;
        this.c = column;
        
        double[][][] dp = new double[n + 1][n + 1][k + 1];

        return f(r, c, n, k, dp);
    }

    private double f(int row, int column, int n, int k, double[][][] dp) {
        if (row >= n || column >= n || row < 0 || column < 0) return 0;

        if (k == 0) return 1;
        
        if (dp[row][column][k] != 0) return dp[row][column][k];

        double res = 0;

        for (int[] dir : directions) {
            int x = dir[0];
            int y = dir[1];
            
            // adding current coordinate to row and column
            res += f(row + x, column + y, n, k - 1, dp);
        }
        
        // finding probability by adding all the possible moves and dividing by the number of moves a knight can travel
        return dp[row][column][k] = res / 8;
    }
}