class Solution { // linear search O(n+m)
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++; // since curr element is smaller than target and rows are sorted in ascending
            } else {
                col--;
            }
        }

        return false;
    }
}
