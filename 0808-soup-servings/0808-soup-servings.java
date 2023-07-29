class Solution {
    
    int[][] operations = {{100,0},{75,25},{50,50},{25,75}};
    
    public double soupServings(int n) {
        
        if (n >= 4800) return 1;
        
        double[][] dp = new double[n+1][n+1];
        
        for (double[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return f(n, n, dp);
    }
    
    private double f(int a, int b, double[][] dp) {
        if (a == 0) {
            if (b == 0) {
                return 0.5;
            }
            return 1;
        }
        
        if (b == 0) return 0;
        
        if (dp[a][b] != -1) {
            return dp[a][b];
        }
        
        double res = 0;
        for (int i = 0; i < 4; i++){
            
            int sub_a = operations[i][0], sub_b=operations[i][1];
            
            res += 0.25 * f(Math.max(0, a - sub_a), Math.max(0, b - sub_b), dp);
        }
        
        return dp[a][b] = res;
    }
}