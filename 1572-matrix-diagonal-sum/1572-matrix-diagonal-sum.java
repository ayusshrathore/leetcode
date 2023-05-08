class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, m = mat[0].length, res = 0;
        
        int row = 0;
        for(int[] arr : mat) {
            if(row == n-row-1) {
                res += arr[row];
                row++;
                continue;
            }
            res += arr[row];
            res += arr[n-row-1];
            
            row++;
        }
        
        return res;
    }
}