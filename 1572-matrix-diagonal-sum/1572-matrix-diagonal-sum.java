class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, res = 0, row = 0;
        
        for(int[] arr : mat) {
            int firstEle = arr[row];
            int secondEle = arr[n-row-1];
            
            if(row == n-row-1) {
                res += firstEle;
                row++;
                continue;
            }
            
            res += firstEle;
            res += secondEle;
            
            row++;
        }
        
        return res;
    }
}