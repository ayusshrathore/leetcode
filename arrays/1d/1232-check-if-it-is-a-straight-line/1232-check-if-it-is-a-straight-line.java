class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        
        int dy = coordinates[1][1] - coordinates[0][1]; // y2 - y1
        int dx = coordinates[1][0] - coordinates[0][0]; // x2 - x1
        
        for(int i = 2; i < n; i++) { // calc slope for each points wrt 0th point    
            
            int dyi = coordinates[i][1] - coordinates[0][1]; // dy/dx wrt 0th idx point
            int dxi = coordinates[i][0] - coordinates[0][0];
            
            /** 
                slope = dy / dx
                dyi / dxi = dy / dx
                dyi * dx = dy * dxi (cross product) 
            **/
            if(dyi * dx != dy * dxi)
                return false;
        }
        
        return true;
    }
}