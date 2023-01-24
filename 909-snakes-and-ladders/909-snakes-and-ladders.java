class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int steps = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(1);
        visited[n-1][0] = true; // mark 1 as true
        while (!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                int curr = q.poll();
                if (curr == n * n) return steps;

                for (int j = 1; j <= 6; j++) {  // checking all outputs of dice
                    if (curr + j > n * n) break;

                    int[] pos = findCoordinates(curr + j, n);
                    int row = pos[0], col = pos[1];
                    if (visited[row][col] == true) continue;

                    visited[row][col] = true;
                    if (board[row][col] == -1) q.add(curr + j); // add output by dice if -1
                    else q.add(board[row][col]); // add value pointed by that index
                }
            }
            steps++;
        }
        return -1;
    }

    private static int[] findCoordinates(int curr, int n) {
        // row_from_top = row - 1 / n
        // row_from_bottom = (n - 1) - row_from_top
        int row = (n - 1) - ((curr - 1) / n);
        int col = (curr - 1) % n;
        // col_from_left = col % n
        // col_from_right = n - 1 - col_from_left

        // if both n & row_from_bottom are even
        if (row % 2 == n % 2) return new int[]{row, n - 1 - col};
        // if both n & row_from_bottom are odd
        else return new int[]{row, col};
    }
}