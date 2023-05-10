class Solution { // Simulation, Arrays
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        
        /* 
            dir 0 : left --> right
            dir 1 : top --> bottom
            dir 2 : right --> left
            dir 3 : bottom --> top
        */
        
        int left = 0, bottom = n-1, right = n-1, top = 0, dir = 0, cnt = 1;
        
        while(left <= right && top <= bottom) {
            
            if(dir == 0) {
                // left --> right
                
                for(int i = left; i <= right; i++)
                    mat[top][i] = cnt++;
                
                top++;
            }
            
            if(dir == 1) {
                // top --> bottom
                
                for(int i = top; i <= bottom; i++)
                    mat[i][right] = cnt++;
                
                right--;
            }
            
            if(dir == 2) {
                // right --> left;
                
                for(int i = right; i >= left; i--)
                    mat[bottom][i] = cnt++;
                    
                bottom--;
            }
            
            if(dir == 3) {
                // bottom --> top
                
                for(int i = bottom; i >= top; i--)
                    mat[i][left] = cnt++;
                
                left++;
            }
            
            dir++;
            
            if(dir == 4)
                dir = 0;            
        }
        
        return mat;
    }
}