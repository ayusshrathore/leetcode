class Solution {
    public void rotate(int[][] mat) {
        int[] temp = new int[mat.length * mat.length];
        int idx = 0;
        for (int i = 0; i < mat.length; i++)
          for (int j = 0; j < mat.length; j++)
            temp[idx++] = mat[i][j];

        idx = 0;
        for (int i = mat.length - 1; i >= 0; i--)
          for (int j = 0; j < mat.length; j++)
            mat[j][i] = temp[idx++];

        for (int i = 0; i < mat.length; i++)
          System.out.println(Arrays.toString(mat[i])); 
        }
}