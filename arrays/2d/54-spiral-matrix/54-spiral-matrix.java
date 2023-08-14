class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length; // rows
        int m = matrix[0].length; // cols
        
        List<Integer> result = new ArrayList<>();
        
        /* 
            dir 0 : left --> right
            dir 1 : top --> bottom
            dir 2 : right --> left
            dir 3 : bottom --> top
        */
        
        int top = 0, bottom = n-1, right = m-1, left = 0, dir = 0;
        
        while(top <= bottom && left <= right) {
            
            if(dir == 0) {
                // left -> right
                
                for(int i = left; i <= right; i++) 
                    result.add(matrix[top][i]);
                
                top++;
            }
            
            else if(dir == 1) {
                // top --> bottom
                
                for(int i = top; i <= bottom; i++)
                    result.add(matrix[i][right]);
                
                right--;
            }
            
            else if(dir == 2) {
                // right --> left
                
                for(int i = right; i >= left; i--)
                    result.add(matrix[bottom][i]);
                
                bottom--;
            }
            
            else if(dir == 3) {
                // bottom --> top
                
                for(int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                
                left++;
            }
            
            dir++;
            
            if(dir == 4)
                dir = 0;
        }
        
        return result;
    }
}