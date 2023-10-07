class Solution {
    public int maximumWealth(int[][] accounts) {

        int n = accounts.length;
        int[] colSum = new int[n];
        int sum;
        for(int row=0;row<n;row++)
        {
            int m = accounts[row].length;
            sum=0;
            
            for(int col=0; col<m;col++)
            {
                sum = sum + accounts[row][col];
                colSum[row] = sum;
            }
        }

        // find the largest element of the array colSum

        int max=colSum[0];

        for(int i=1;i<n;i++)
        {
            if(max<colSum[i])
            {
                max = colSum[i];
            }
        }
        
        return max;
        
    }
}