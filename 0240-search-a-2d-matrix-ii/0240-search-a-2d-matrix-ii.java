class Solution { // binary search O(4^(log₂(min(n, m))))
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        return binarySearch(matrix, target, 0, 0, n - 1, m - 1);
    }
    
    private boolean binarySearch(int[][] matrix, int target, int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return false;
        }
        
        int midRow = (rowStart + rowEnd) / 2;
        int midCol = (colStart + colEnd) / 2;
        
        if (matrix[midRow][midCol] == target) {
            return true;
        } else if (matrix[midRow][midCol] < target) {
            return binarySearch(matrix, target, rowStart, midCol + 1, midRow, colEnd) || 
                   binarySearch(matrix, target, midRow + 1, colStart, rowEnd, colEnd);
        } else {
            return binarySearch(matrix, target, rowStart, colStart, midRow - 1, colEnd) || 
                   binarySearch(matrix, target, midRow, colStart, rowEnd, midCol - 1);
        }
    }
}
