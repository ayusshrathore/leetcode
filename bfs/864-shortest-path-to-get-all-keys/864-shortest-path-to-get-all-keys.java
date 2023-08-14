class Solution { // BFS
    
    /*
     Notes
     
     How to update the status of the key??
     
     The status of the key is updated by using a decimal number representation. Each bit in the decimal number represents a key. 
     For example, if we have keys 'a', 'b', and 'c', the decimal representation would be as follows:
 
        - Key 'a': 1 (binary: 001)
        - Key 'b': 2 (binary: 010)
        - Key 'c': 4 (binary: 100)
 
     To update the key status, we perform bitwise OR operation to set the corresponding bit to 1. 
     For example, if we have keys 'a' and 'c', the decimal representation would be 5 (binary: 101)
     
     The significance of shifting is to get desired as least significant bit for a easier check
     
     */
    
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        
        Queue<int[]> que = new ArrayDeque<>(); // {x, y, steps, currKeyStatusDecimal}
        
        int count = 0;
        
        for(int i = 0; i < m; i++) { // count total keys
            for(int j = 0; j < n; j++) {
                if(grid[i].charAt(j) == '@') {
                    que.add(new int[]{i, j, 0, 0});
                } else if(grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    count++;
                }
            }
        }
        
        int finalKeyStatusDecimal = (int)Math.pow(2, count) - 1;
        
        int[][][] visited = new int[m][n][finalKeyStatusDecimal+1];
        
        while(!que.isEmpty()) {
            int[] tmp = que.peek();
            que.poll();
            
            int i = tmp[0];
            int j = tmp[1];
            int steps = tmp[2];
            int currKeyStatusDecimal = tmp[3];
            
            if(finalKeyStatusDecimal == currKeyStatusDecimal)
                return steps;
            
            for(int[] dir : directions) {
                int new_i = dir[0] + i;
                int new_j = dir[1] + j;
                
                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i].charAt(new_j) != '#') { // out of bounds or wall encountered
                    char ch = grid[new_i].charAt(new_j);
                    
                    if(ch >= 'A' && ch <= 'F') { // lock
                        if(visited[new_i][new_j][currKeyStatusDecimal] == 0 && (currKeyStatusDecimal >> (ch - 'A') & 1) == 1) { // do have key for this lock
                            visited[new_i][new_j][currKeyStatusDecimal] = 1;
                            que.add(new int[]{new_i, new_j, steps+1, currKeyStatusDecimal});
                        }
                        
                    } else if(ch >= 'a' && ch <= 'f') { // key
                        
                        int newKeyStatusDecimal = currKeyStatusDecimal | (1 << (ch - 'a'));
                        if(visited[new_i][new_j][newKeyStatusDecimal] == 0) {
                            visited[new_i][new_j][newKeyStatusDecimal] = 1;
                            que.add(new int[]{new_i, new_j, steps+1, newKeyStatusDecimal});
                        }
                        
                    } else { // '.'
                        if(visited[new_i][new_j][currKeyStatusDecimal] == 0) {
                            visited[new_i][new_j][currKeyStatusDecimal] = 1;
                            que.add(new int[]{new_i, new_j, steps+1, currKeyStatusDecimal});
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}