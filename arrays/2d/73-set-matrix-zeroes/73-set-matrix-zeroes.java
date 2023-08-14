class Solution {
  public void setZeroes(int[][] arr) {
    boolean flag = true;
    for (int i = 0; i < arr.length; i++)
      for (int j = 0; j < arr[0].length; j++)
        if (arr[i][j] == 0) {
            setItemsToZero(arr, i, j);
            flag = false;
        }

    for (int i = 0; i < arr.length; i++)
      for (int j = 0; j < arr[0].length; j++)
        if (arr[i][j] == -1 && flag == false)
          arr[i][j] = 0;
  }

  private void setItemsToZero(int[][] arr, int a, int b) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i][b] == 0)
        continue;
      else
        arr[i][b] = -1;
    }

    for (int i = 0; i < arr[0].length; i++) {
      if (arr[a][i] == 0)
        continue;
      else
        arr[a][i] = -1;
    }
  }
}