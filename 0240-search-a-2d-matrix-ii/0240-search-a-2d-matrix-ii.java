class Solution { // Binary search O(n * log(m))
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(matrix[i], target) >= 0) {
                return true;
            }
        }

        return false;
    }
}
