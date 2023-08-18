class Solution { // DFS, TC: O(n*m)
    private int n, m;
    private int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        this.m = mat.length;
        this.n = mat[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0 && !visited[i][j]) {
                    solve(i, j, visited, mat, 0);
                }
            }
        }
        return mat;
    }

    private void solve (int i, int j, boolean[][] visited, int[][] mat, int lvl) {
        if (i < 0 || i >= m || j < 0 || j >= n || (mat[i][j]==0 && lvl != 0)) { // out of bounds check or if cell contains zero & it is not the same cell where we started
            return;
        }
        
        if (visited[i][j] && mat[i][j] <= lvl) { // if cell is already been visited & distance so far is greater than already calculated one, so no need to calculate further
            return;
        }

        visited[i][j] = true;

        mat[i][j] = lvl;

        for (int[] d : dir) {
            int _m = i + d[0];
            int _n = j + d[1];
            
            solve(_m, _n, visited, mat, lvl+1);
        }

    }
}